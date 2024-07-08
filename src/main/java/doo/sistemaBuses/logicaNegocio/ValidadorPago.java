package doo.sistemaBuses.logicaNegocio;

/**
 * Validador de pago con tarjetas, clase creada como funcionalidad opcional
 * @author Santiago Diaz
 */
public class ValidadorPago {
    private String cardType;
    private long cardNumber;
    private int cvv;
    private String cardholderName;

    /**
     * Constructor donde se crea el Validador con una tarjeta especifica.
     *
     * @param cardType       Tipo de tarjeta, debito o credito (cadena o string)
     * @param cardNumber     El numero de tarjeta en long
     * @param cvv            Entero codigo de validacion
     * @param cardholderName Cadena o string con el nombre del tarjetahabiente
     */
    public ValidadorPago(String cardType, long cardNumber, int cvv, String cardholderName) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardholderName = cardholderName;
    }

    /**
     * Fyncion que devuelve si la compra se puede realizar o no segun lo ingresado al crear el validador
     *
     * @return Valor booleano true o false que corresponde a la validez de tarjeta
     */
    public boolean validar() {
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() != 16) {
            return false;
        }

        String cvvStr = Integer.toString(cvv);
        if (cvvStr.length() != 3 && cvvStr.length() != 4) {
            return false;
        }

        return !cardholderName.isEmpty();

    }
}