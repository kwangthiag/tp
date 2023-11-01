package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all appointments occurring after the current date in the address book to the user.
 */
public class UpcomingCommand extends Command {
    public static final String COMMAND_WORD = "upcoming";

    public static final String MESSAGE_SUCCESS = "Listed all upcoming appointments";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all upcoming appointments.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAppointmentList(
                appointment -> appointment.getStartTime().isAfter(LocalDateTime.now()));
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
