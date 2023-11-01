package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments to produce an {@code ExitCommand}.
 */
public class ExitCommandParser {

    /**
     * Parses the given {@code String} of arguments to produce an {@code ExitCommand}.
     * <p>
     * This parser expects no arguments, and any provided argument will result in a {@code ParseException}.
     *
     * @param args The arguments string, which should be empty for this command.
     * @return An {@code ExitCommand} ready for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public ExitCommand parse(String args) throws ParseException {
        if (!args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExitCommand.MESSAGE_USAGE));
        }
        return new ExitCommand();
    }
}
