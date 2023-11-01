package seedu.address.logic.parser.personparser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.personcommands.PatientsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments to produce a {@code PatientsCommand}.
 */
public class PatientsCommandParser {

    /**
     * Parses the given {@code String} of arguments to produce a {@code PatientsCommand}.
     * <p>
     * This parser expects no arguments. If any argument is provided, a {@code ParseException} is thrown.
     *
     * @param args The arguments string, which should be empty for this command.
     * @return A {@code PatientsCommand} ready for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public PatientsCommand parse(String args) throws ParseException {
        if (!args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, PatientsCommand.MESSAGE_USAGE));
        }
        return new PatientsCommand();
    }
}
