package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT_END;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT_START;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_APPOINTMENTS;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.AppointmentDescription;
import seedu.address.model.appointment.AppointmentTime;
import seedu.address.model.person.Person;

/**
 * Reschedules an existing appointment
 */
public class RescheduleCommand extends Command {
    public static final String COMMAND_WORD = "reschedule";


    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Reschedules the appointment identified "
            + "by the index number used in the displayed appointment list.\n"
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: " + PREFIX_ID + "(must be a positive integer) "
            + "[" + PREFIX_APPOINTMENT_START + "APPOINTMENT START DATE AND TIME] "
            + "[" + PREFIX_APPOINTMENT_END + "APPOINTMENT END DATE AND TIME]\n"
            + "Example: " + PREFIX_ID + " 1 "
            + PREFIX_APPOINTMENT_START + "2023/05/02 09:00 "
            + PREFIX_APPOINTMENT_END + "2023/05/02 11:00 ";

    public static final String MESSAGE_SUCCESS = "Patient appointment rescheduled: %1$s";
    public static final String MESSAGE_NO_APPOINTMENT_FOUND = "No such appointment exists in the records";
    public static final String MESSAGE_DUPLICATE_APPOINTMENT = "This appointment already exists in the records";

    private final Index index;

    private final AppointmentTime appointmentTime;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public RescheduleCommand(Index index, AppointmentTime appointmentTime) {
        requireNonNull(index);
        this.index = index;
        this.appointmentTime = appointmentTime;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Appointment> lastShownList = model.getFilteredAppointmentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_NO_APPOINTMENT_FOUND);
        }

        Appointment appointmentToReschedule = lastShownList.get(index.getZeroBased());
        Appointment rescheduledAppointment = createRescheduledAppointment(appointmentToReschedule, appointmentTime);

        if (!appointmentToReschedule.isSameAppointment(rescheduledAppointment)
                && model.hasAppointment(rescheduledAppointment)) {
            throw new CommandException(MESSAGE_DUPLICATE_APPOINTMENT);
        }

        model.setAppointment(appointmentToReschedule, rescheduledAppointment);
        model.updateFilteredAppointmentList(PREDICATE_SHOW_ALL_APPOINTMENTS);
        return new CommandResult(
                String.format(MESSAGE_SUCCESS, Messages.format(rescheduledAppointment)), false, false);
    }

    private static Appointment createRescheduledAppointment(Appointment appointmentToReschedule,
                                                             AppointmentTime newTime) {
        assert appointmentToReschedule != null;

        Person patient = appointmentToReschedule.getPerson();
        AppointmentDescription description = appointmentToReschedule.getAppointmentDescription();
        return new Appointment(patient, newTime, description);
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RescheduleCommand)) {
            return false;
        }

        RescheduleCommand e = (RescheduleCommand) other;
        return index.equals(e.index);
    }

}
