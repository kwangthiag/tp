package seedu.address.logic.parser.appointmentparser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.appointmentcommands.TodayCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments to produce a {@code TodayCommand}.
 */
public class TodayCommandParser {

    /**
     * Parses the given {@code String} of arguments to produce a {@code TodayCommand}.
     * <p>
     * This parser expects no arguments. If any argument is provided, a {@code ParseException} is thrown.
     *
     * @param args The arguments string, which should be empty for this command.
     * @return A {@code TodayCommand} ready for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public TodayCommand parse(String args) throws ParseException {
        if (!args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, TodayCommand.MESSAGE_USAGE));
        }
        return new TodayCommand();
    }
}
