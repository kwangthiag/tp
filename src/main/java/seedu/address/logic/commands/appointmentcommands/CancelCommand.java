package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.appointmentcommands.RescheduleCommand.MESSAGE_NO_APPOINTMENT_FOUND;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.personcommands.DeleteCommand;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;


/**
 * CancelCommand class to cancel an existing appointment.
 */
public class CancelCommand extends Command {

    public static final String COMMAND_WORD = "cancel";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Cancels the appointment with the corresponding"
            + " appointment ID\n"
            + "Parameters: "
            + PREFIX_ID + "ID \n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_ID + "2";
    public static final String MESSAGE_CANCEL_APPOINTMENT_SUCCESS = "Cancelled Appointment: %1$s.";


    private final Index index;

    /**
     * Constructor for the CancelCommand class
     * @param index
     */
    public CancelCommand(Index index) {
        requireNonNull(index);
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Appointment> lastShownList = model.getFilteredAppointmentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_NO_APPOINTMENT_FOUND);
        }

        Appointment appointmentToDelete = lastShownList.get(index.getZeroBased());
        model.deleteAppointment(appointmentToDelete);
        return new CommandResult(String.format(MESSAGE_CANCEL_APPOINTMENT_SUCCESS,
                Messages.format(appointmentToDelete)));
    }



    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteCommand)) {
            return false;
        }

        CancelCommand otherCancelCommand = (CancelCommand) other;
        return index.equals(otherCancelCommand.index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", index)
                .toString();
    }
}
