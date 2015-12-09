/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws_client_application;

/**
 *
 * @author monkey_001
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Resultado = "+ add(3,4));
    }

    private static int add(int i, int j) {
        org.me.test.CalculatorWS_Service service = new org.me.test.CalculatorWS_Service();
        org.me.test.CalculatorWS port = service.getCalculatorWSPort();
        return port.add(i, j);
    }
}
