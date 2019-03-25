package aboutSocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;

public class ClientTest extends JFrame implements ActionListener, Runnable {
    private JTextField jtf = new JTextField(20);

    private Socket s;
    private JTextArea jta;
    private JPanel jp;

    private JScrollBar sbar;

    public ClientTest() {
        this.setTitle("client");

        jta = new JTextArea();
        jta.setLineWrap(true); //激活自动换行功能
        jta.setWrapStyleWord(true); // 激活断行不断字功能
        JScrollPane jsp = new JScrollPane(jta);

        sbar=jsp.getVerticalScrollBar();
        sbar.setValue(sbar.getMaximum());

        this.add(jsp);

        jp = new JPanel();
        final JButton send = new JButton("send");
        send.addActionListener(this);
        jp.add(jtf);
        jp.add(send);

        this.add(jp, BorderLayout.SOUTH);

        this.setSize(400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 客户端套接字
        try {
            s = new Socket("localhost", 10008);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    send.doClick();
                }
            }
        });
    }

    public static void main(String[] args) {
        new ClientTest();
    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        try {
            String message = jtf.getText();
            if ("".equals(message)) {
                JOptionPane.showMessageDialog(jp, "nothing does't makes sense", "alert",JOptionPane.WARNING_MESSAGE);
                return;
            }
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(jtf.getText());
            jta.append("me:"+message+ "\n");
            jtf.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            while (!s.isInputShutdown()) {
                InputStream is = s.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                jta.append(line + "\n");
                jta.setCaretPosition(jta.getDocument().getLength());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}