package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments to produce a {@code ClearCommand}.
 */
public class ClearCommandParser {

    /**
     * Parses the given {@code String} of arguments to produce a {@code ClearCommand}.
     * <p>
     * The function expects no arguments, and any provided argument will cause a {@code ParseException}.
     *
     * @param args The arguments string, which should be empty for this command.
     * @return A {@code ClearCommand} ready for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public ClearCommand parse(String args) throws ParseException {
        if (!args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearCommand.MESSAGE_USAGE));
        }
        return new ClearCommand();
    }
}
