package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * this class is developed on day-18
 */
public class Des {
    static Logger log = Logger.getLogger(Des.class.getName());
    // creating an instance of the Cipher class for encryption, decryption and vector
    private static Cipher encrypt;
    private static Cipher decrypt;
    private static final byte[] initialization_vector = { 22, 33, 11, 44, 55, 99, 66, 77 };
  

    /**
     * this is the main method for the class Des
     * 
     * @param args
     */
    public static void main(String[] args) {

        String option,filename,encryptedfile, decryptedfile;
        boolean temp = true;

        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is DES Encryption program. Do you want to continue?");
        
     
        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {
                case "1" :
                    log.info("Enter filename to encrypt");
                    filename = System.console().readLine();
                    // path of the file that we want to encrypt
                    filename = "C:/Users/anu-d/Desktop/tasks/Phase1/" + filename;

                    //Filepath for encryptiona and decryption
                    encryptedfile = "C:/Users/anu-d/Desktop/tasks/Phase1/encryptdata.txt";
                    decryptedfile = "C:/Users/anu-d/Desktop/tasks/Phase1/decryptdata.txt";

                    // generating keys by using the KeyGenerator class
                    SecretKey scrtkey = KeyGenerator.getInstance("DES").generateKey();
                    AlgorithmParameterSpec aps = new IvParameterSpec(initialization_vector);

                    // setting encryption mode
                    encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
                    encrypt.init(Cipher.ENCRYPT_MODE, scrtkey, aps);

                    // setting decryption mode
                    decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
                    decrypt.init(Cipher.DECRYPT_MODE, scrtkey, aps);

                
                    // calling encrypt() method to encrypt the file
                    encryption(new FileInputStream(filename), new FileOutputStream(encryptedfile));

                    // calling decrypt() method to decrypt the file
                    decryption(new FileInputStream(encryptedfile), new FileOutputStream(decryptedfile));

                    // prints the stetment if the program runs successfully
                    log.info("The encrypted and decrypted files have been created successfully.");
                    break;

                case "2" :
                    log.info("program ended");
                    temp = false;
                    break;

                default:
                    log.info("Please enter from  the given values only");
                    break;
                }

            }
            // catching multiple exceptions by using the | (or) operator in a single catch
            // block
            catch (Exception e) {
                log.info("Error! Program terminated");
                // log.debug(e.toString());
            }
        }
    }

    /**
     * method for encryption
     * 
     * @param input
     * @param output
     * @throws IOException
     */
    private static void encryption(InputStream input, OutputStream output) throws IOException {
        output = new CipherOutputStream(output, encrypt);
        // calling the writeBytes() method to write the encrypted bytes to the file
        writeBytes(input, output);
    }

    /**
     * method for decryption
     * 
     * @param input
     * @param output
     * @throws IOException
     */
    private static void decryption(InputStream input, OutputStream output) throws IOException {
        input = new CipherInputStream(input, decrypt);
        // calling the writeBytes() method to write the decrypted bytes to the file
        writeBytes(input, output);
    }

    /**
     * method for writting bytes to the files
     * 
     * @param input
     * @param output
     * @throws IOException
     */
    private static void writeBytes(InputStream input, OutputStream output) throws IOException {
        byte[] writeBuffer = new byte[512];
        int readBytes = 0;
        while ((readBytes = input.read(writeBuffer)) >= 0) {
            output.write(writeBuffer, 0, readBytes);
        }
        // closing the output stream
        output.close();
        // closing the input stream
        input.close();
    }
}
