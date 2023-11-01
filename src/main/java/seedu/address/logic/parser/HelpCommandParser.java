package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments to produce a {@code HelpCommand}.
 */
public class HelpCommandParser {

    /**
     * Parses the given {@code String} of arguments to produce a {@code HelpCommand}.
     * <p>
     * This parser expects no arguments. If any argument is provided, a {@code ParseException} is thrown.
     *
     * @param args The arguments string, which should be empty for this command.
     * @return A {@code HelpCommand} ready for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public HelpCommand parse(String args) throws ParseException {
        if (!args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        return new HelpCommand();
    }
}
