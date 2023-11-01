package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_APPOINTMENTS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all appointments in the address book to the user.
 */
public class AppointmentsCommand extends Command {
    public static final String COMMAND_WORD = "appointments";

    public static final String MESSAGE_SUCCESS = "Listed all appointments";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all appointments\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAppointmentList(PREDICATE_SHOW_ALL_APPOINTMENTS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
