/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Services.DateService;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ADMIN
 */
public class testd {
  static int sumDig(int n)
    {
        int a = 0;
        while (n > 0)
        {
            a = a + n % 10;
            n = n / 10;
        }
        return a;
    }
 
    static boolean isValidIMEI(long n)
    {
        // Converting the number into String
        // for finding length
        String s = Long.toString(n);
        int len = s.length();
 
        if (len != 15)
            return false;
 
        int sum = 0;
        for (int i = len; i >= 1; i--)
        {
            int d = (int)(n % 10);
 
            // Doubling every alternate digit
            if (i % 2 == 0)
                d = 2 * d;
 
            // Finding sum of the digits
            sum += sumDig(d);
            n = n / 10;
        }
        System.out.println("sum " + sum);
        return (sum % 10 == 0);
    }
 
    // Driver code
    public static void main(String args[]) throws IOException
    {
        // 15 digits cannot be stored in 'int' data type
        long n = 517283577994526l;
 
        if (isValidIMEI(n))
            System.out.println("Valid IMEI Code");
        else
            System.out.println("Invalid IMEI Code");
 
    }
//    public static void main(String... args) {
        
//        Date d2 = new Date();
//        Date d1 = DateService.toDate("01-12-2021", "dd-MM-yyyy");
//        long diff = d2.getTime() - d1.getTime();
//        System.out.println(diff);
//        System.out.println(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

//        JFrame frame = new JFrame();
//        JPanel panel = new JPanel();
//        for (int i = 0; i < 10; i++) {
//            panel.add(new JButton("Hello-" + i));
//        }
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(50, 30, 300, 50);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(800, 400));
//        contentPane.add(scrollPane);
//        frame.setContentPane(contentPane);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
