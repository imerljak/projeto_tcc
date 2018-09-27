package br.com.imerljak.common.control;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TelefoneValidator implements Validator<String> {

    public static final Pattern FORMATED = Pattern.compile("\\((\\d{2})\\)\\s(\\d{4,5})-(\\d{4})");
    public static final Pattern UNFORMATED = Pattern.compile("(\\d{2})(\\d{4,5})(\\d{4})");

    private boolean isFormatted = false;
    private MessageProducer messageProducer;

    /**
     * Este considera, por padrão, que as cadeias não estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public TelefoneValidator() {
        messageProducer = new SimpleMessageProducer();
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens. Leva em conta se o valor está ou não formatado.
     *
     * @param isFormatted considera cadeia no formato de Telefone: "(dd) dddd[d]-dddd" onde
     *                    "d" é um dígito decimal, e [d] é opcional.
     */
    public TelefoneValidator(boolean isFormatted) {
        this.isFormatted = isFormatted;
        messageProducer = new SimpleMessageProducer();
    }

    /**
     * <p>
     * Construtor do Validador de Telefone. Leva em consideração se o valor está formatado.
     * </p>
     * <p>
     *
     * @param messageProducer produtor de mensagem de erro.
     * @param isFormatted     considera cadeia no formato de CNPJ: "(dd) dddd[d]-dddd" onde
     *                        "d" é um dígito decimal, e [d] é opcional.
     */
    public TelefoneValidator(boolean isFormatted, MessageProducer messageProducer) {
        this.isFormatted = isFormatted;
        this.messageProducer = messageProducer;
    }

    public TelefoneValidator(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    private List<ValidationMessage> getInvalidValues(String telefone) {
        List<ValidationMessage> errors = new ArrayList<>();

        if (telefone != null) {
            if (isFormatted && !FORMATED.matcher(telefone).matches()) {
                errors.add(messageProducer.getMessage(TelefoneError.INVALID_FORMAT));
            }

            String unformatedTelefone;
            try {
                unformatedTelefone = new TelefoneFormatter().unformat(telefone);
            } catch (IllegalArgumentException e) {
                errors.add(messageProducer.getMessage(TelefoneError.INVALID_DIGITS));
                return errors;
            }

            if ((unformatedTelefone.length() != 10 && unformatedTelefone.length() != 11) || !unformatedTelefone.matches("[0-9]*")) {
                errors.add(messageProducer.getMessage(TelefoneError.INVALID_DIGITS));
            }
        }

        return errors;
    }

    @Override
    public void assertValid(String s) {

        List<ValidationMessage> errors = getInvalidValues(s);
        if (!errors.isEmpty()) {
            throw new InvalidStateException(errors);
        }
    }

    @Override
    public List<ValidationMessage> invalidMessagesFor(String s) {
        return getInvalidValues(s);
    }

    @Override
    public boolean isEligible(String s) {
        if (isFormatted) {
            return FORMATED.matcher(s).matches();
        }

        return FORMATED.matcher(s).matches();
    }

    @Override
    public String generateRandomValid() {
        final String randomDigitos = new DigitoGenerator().generate(10);
        if (isFormatted) {
            return String.format(randomDigitos, "(##) ####-####");
        }
        return randomDigitos;
    }
}
