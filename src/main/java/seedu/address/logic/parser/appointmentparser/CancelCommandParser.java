package seedu.address.logic.parser.appointmentparser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.appointmentcommands.CancelCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;



/**
 * Parses input arguments and creates a new CancelCommand object
 */
public class CancelCommandParser implements Parser<CancelCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CancelCommand
     * and returns a CancelCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CancelCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_ID);
        Index index;

        if (argMultimap.getValue(PREFIX_ID).isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, CancelCommand.MESSAGE_USAGE));
        }
        index = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_ID).get());
        return new CancelCommand(index);
    }

}
