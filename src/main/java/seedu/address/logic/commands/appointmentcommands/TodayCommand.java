package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all appointments occurring on the current date in the address book to the user.
 */
public class TodayCommand extends Command {
    public static final String COMMAND_WORD = "today";

    public static final String MESSAGE_SUCCESS = "Listed all appointments occurring today";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all appointments occurring today\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAppointmentList(
                appointment -> appointment.getStartTime().toLocalDate().isEqual(LocalDate.now()));
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
