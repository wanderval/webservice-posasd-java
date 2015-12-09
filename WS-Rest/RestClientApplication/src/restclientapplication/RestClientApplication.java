/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclientapplication;

/**
 *
 * @author monkey_001
 */
public class RestClientApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestClient client = new TestClient();
        System.out.println("Testando GET...");
        String response = client.getText();
        System.out.println("GET = "+response);

        System.out.println("Testando PUT...");
        client.putText("Novo Teste");
        
        System.out.println("Testando GET depois do PUT...");
        String response1 = client.getText();
        System.out.println("GET = "+response1);
        client.close();
    }
    
}
