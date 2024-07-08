package doo.sistemaBuses.logicaNegocio;

public class ValidadorPago {
    private String cardType;
    private long cardNumber;
    private int cvv;
    private String cardholderName;

    public ValidadorPago(String cardType, long cardNumber, int cvv, String cardholderName) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardholderName = cardholderName;
    }

    public boolean validar() {
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() != 16) {
            return false;
        }

        String cvvStr = Integer.toString(cvv);
        if (cvvStr.length() != 3 && cvvStr.length() != 4) {
            return false;
        }

        if (cardholderName.isEmpty()) {
            return false;
        }

        return true;
    }
}