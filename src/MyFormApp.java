/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adobe.acrobat.Viewer;
import com.adobe.acrobat.ViewerCommand;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.apache.commons.io.FileUtils;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.commons.io.FilenameUtils;
import javax.imageio.ImageIO;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static org.jpedal.examples.simpleviewer.SimpleViewer.file;
/**
 *
 * @author ball_
 */
public class MyFormApp extends javax.swing.JFrame {

    /**
     * Creates new form MyFormApp
     */
    int i =0;   
    String folderPath = null;
    File[] fileList = null;
    String[] data = null;
    String PATH = null;
    DefaultListModel<Book> model = new DefaultListModel();  //ตั้งตัวแปรทำ icon สำหรับ LIST
    public MyFormApp(String pathfolder) {
        folderPath = pathfolder;
        initComponents();
        //File[] fileList = getFileList(folderPath); //เรียกใช้ฟังก์ชั่นหารายชื่อไฟล์ แล้วเก็บรายชื่อไฟล์
        //String[] data = new String[fileList.length];  
        //String PATH = folderPath+"\\"; //ที่อยู่ที่เก็บไฟล์หนังสือและภาพ
        fileList = getFileList(folderPath); //เรียกใช้ฟังก์ชั่นหารายชื่อไฟล์ แล้วเก็บรายชื่อไฟล์
        data = new String[fileList.length];  
        PATH = folderPath+"\\"; //ที่อยู่ที่เก็บไฟล์หนังสือและภาพ
    }
         
        
        
     public static File[] getFileList(String dirPath) { // ฟังก์ชั่นสำหรับค้นหาไฟล์ pdf ที่อยู่ในโฟล์เดอร์
            File dir = new File(dirPath);   

            File[] fileList = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) { //ค้นหารายชื่อไฟล์ทั้งหมดในโฟล์เดอร์
                    return name.endsWith(".pdf");
                }
            });
            return fileList;
        }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
     private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException { //ฟังก์ชั่น ก๊อปปี้ไฟล์pdf เมื่อทำการเพิ่มหนังสือ ไปเก็บยังโฟล์เดอร์เฉพาะ
FileUtils.copyFile(source, dest); 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Openbutton = new javax.swing.JButton();
        Addbutton = new javax.swing.JButton();
        Removebutton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<Book>();
        btLogout = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(null);

        Openbutton.setText("Open");
        Openbutton.setPreferredSize(new java.awt.Dimension(60, 30));
        Openbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpenbuttonMouseClicked(evt);
            }
        });
        jPanel1.add(Openbutton);
        Openbutton.setBounds(660, 100, 110, 40);

        Addbutton.setText("Add");
        Addbutton.setPreferredSize(new java.awt.Dimension(60, 30));
        Addbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbuttonMouseClicked(evt);
            }
        });
        Addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(Addbutton);
        Addbutton.setBounds(661, 150, 110, 40);

        Removebutton.setText("Remove");
        Removebutton.setPreferredSize(new java.awt.Dimension(60, 30));
        Removebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemovebuttonMouseClicked(evt);
            }
        });
        jPanel1.add(Removebutton);
        Removebutton.setBounds(660, 200, 110, 40);

        jList2.setBackground(new java.awt.Color(204, 204, 204));

        jList2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jList2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 80, 540, 432);

        btLogout.setText("Logout");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btLogout);
        btLogout.setBounds(660, 260, 110, 50);

        jTabbedPane1.addTab("      main     ", jPanel1);

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setLayout(new javax.swing.OverlayLayout(jPanel5));
        jTabbedPane1.addTab("       Display PDF     ", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        setBounds(0, 0, 1074, 830);
    }// </editor-fold>//GEN-END:initComponents

    private void RemovebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovebuttonMouseClicked
        // TODO add your handling code here:JDialog.setDefaultLookAndFeelDecorated(true);
        //ฟังก์ชั่นจะทำการลบ รายชื่อไฟล์ที่ต้องการ ลบ เมื่อกดปุ่มลบ
        int index = jList2.getSelectedIndex(); //ตำแหน่งรายชื่อที่เลือก
        int response = JOptionPane.showConfirmDialog(null, "Do you want to delete "+model.getElementAt(index)+" ?", "Confirm", //หน้าต่างแจ้งเตือนคอนเฟิร์มเพื่อลบ
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {//กดตกลงจะทำตามเงื่อนไข

            if (model.getSize() > 0)
            System.out.println( PATH+model.getElementAt(index));//แสดงรายชื่อที่ลบ

            deleteDir(new File(PATH+model.getElementAt(index)));//ลบไฟล์ pdf ในโฟล์เดอร์
            deleteDir(new File(PATH+model.getElementAt(index).getIconName()+".png"));//ลบไฟล์รูปในโฟล์เดอร์
            model.removeElementAt(index);//ลบรายชื่อ ในหนน้าต่างLIST
                
        }
    }//GEN-LAST:event_RemovebuttonMouseClicked

    private void AddbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbuttonMouseClicked
        // TODO add your handling code here:
        //ฟังก์ชั่น เพิ่มหนังสือเมื่อกดปุ่มเพิ่ม
        JFileChooser fileChooser = new JFileChooser(); //เปิดหน้าต่างเลือกไฟล์
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));//แสดงเฉพาะpdf
      fileChooser.setAcceptAllFileFilterUsed(false);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {//เมื่อเลือกไฟล์แล้วตกตกลง
            File selectedFile = fileChooser.getSelectedFile(); 
            try {
                pdfToimage(selectedFile); //ทำการเซฟรูปหน้าปกของไฟล์ที่เลือก
            } catch (IOException ex) {
                Logger.getLogger(MyFormApp.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(selectedFile.getName()); //แสดงรายชื่อที่หนังสือที่เลือกเพิ่ม
            File source = new File(""+selectedFile);
            File dest = new File(PATH+ selectedFile.getName());
            //copy file conventional way using Stream
            long start = System.nanoTime();
            //copy files using apache commons io
            start = System.nanoTime();
            int a=i+1;
            String imagename = FilenameUtils.removeExtension(selectedFile.getName());
            model.addElement(new Book(selectedFile.getName(), ""+a , imagename,PATH)); //ใส่รายชื่อในlist
            i=i+1;
            jList2.setModel(model);
            jList2.setCellRenderer(new BookRenderer());
            try {
                copyFileUsingApacheCommonsIO(source, dest); //ก็อปปี้ไฟล์ไปใส่ในโฟล์เดอร์เฉพาะ
            } catch (IOException ex) {
                Logger.getLogger(MyFormApp.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Time taken by Apache Commons IO Copy = "+(System.nanoTime()-start));
        }
    }//GEN-LAST:event_AddbuttonMouseClicked

    private void OpenbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenbuttonMouseClicked
        // TODO add your handling code here:
        int index = jList2.getSelectedIndex();
        System.out.println( model.getElementAt(index)); //แสดงรายชื่อไฟล์ที่เปิด
        openMenuItemActionPerformed(); //เรียกใช้ฟังก์ชั่นเพื่อเปิด หนังสือ ในแทปที่ 2
     
    }//GEN-LAST:event_OpenbuttonMouseClicked

    private void jList2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jList2AncestorAdded
        // TODO add your handling code here:
        // ฟังก์ชั่น LIST หนังสือ
        for(File file : fileList) {  //ไล่รายชื่อ

            data[i] = (file.getName());
            System.out.println(data[i]);
            String imagename = FilenameUtils.removeExtension(data[i]);
             int a=i+1;
            model.addElement(new Book(data[i], ""+a, imagename,PATH) ); //ใส่ข้อมูล ลำดับหนังสือ ชื่อรูปภาพ ที่อยู่ของภาพ สำหรับทำไอคอน
            i=i+1;

        }
        jList2.setModel(model);
        jList2.setCellRenderer(new BookRenderer());
    }//GEN-LAST:event_jList2AncestorAdded

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        dispose();
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }//GEN-LAST:event_btLogoutActionPerformed

    private void AddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddbuttonActionPerformed


    
    void openMenuItemActionPerformed() { //ฟังก์ชั่นเปิด หนังสือ
            int index = jList2.getSelectedIndex(); //ตำแหน่งที่เลือก
            try
            {
                FileInputStream inputStream = new FileInputStream(PATH+model.getElementAt(index)); //เปิดไฟล์ที่เลือก
                Viewer viewer = new Viewer();
                viewer.setDocumentInputStream( inputStream );//set ไฟล์ที่จะเปิด

                jPanel5.removeAll(); //ลบข้อมูลเก่าที่แสดงก่อนหน้า
               
               jPanel5.add(viewer);//ใส่ข้อมูลที่จะแสดง
                viewer.activate();
                 
                jPanel5.validate();
                
            }
            catch (FileNotFoundException ex)
            {
                JOptionPane.showMessageDialog(this,"Cannot find the file!");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Cannot open the file!");
            }
        
    }

    public static boolean deleteDir(File dir) { //ฟังก์ชั่นลบไฟล์
      if (dir.isDirectory()) {
         String[] children = dir.list();
         for (int i = 0; i < children.length; i++) {
            boolean success = deleteDir
            (new File(dir, children[i]));
            if (!success) {
               return false;
            }
         }
      }
      return dir.delete();
      
  }
    void pdfToimage(File filename) throws FileNotFoundException, IOException { //แปลงpdfเป็นรูปภาพ เฉพาะหน้าปก
        
        // TODO Auto-generated method stub
        File pdfFile = new File(filename.toString()); //เปิดไฟล์ pdf
        RandomAccessFile raf = new RandomAccessFile(pdfFile, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        PDFFile pdf = new PDFFile(buf);

        int i=0;
        String fileNameWithOutExt = FilenameUtils.removeExtension(filename.getName());  
       
    
    
        Rectangle rect = new Rectangle(0, 0, (int) pdf.getPage(i).getBBox().getWidth(), //ตั้งค่ารูป
                (int) pdf.getPage(i).getBBox().getHeight());
        BufferedImage bufferedImage = new BufferedImage(100, 100,
                         BufferedImage.TYPE_INT_RGB);

        Image image = pdf.getPage(i).getImage(rect.width, rect.height,    // width & height
                   rect,                       // clip rect
                   null,                       // null for the ImageObserver
                   true,                       // fill background with white
                   true                        // block until drawing is done
        );
        Graphics2D bufImageGraphics = bufferedImage.createGraphics();
        bufImageGraphics.drawImage(image.getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING),0,0,null);
     
        ImageIO.write(bufferedImage, "PNG", new File( PATH+fileNameWithOutExt+".png" )); //บันทึกภาพ 
    }
    /**
     * @param args the command line arguments
     */
    void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFormApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFormApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFormApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFormApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
    
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFormApp(folderPath).setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbutton;
    private javax.swing.JButton Openbutton;
    private javax.swing.JButton Removebutton;
    private javax.swing.JButton btLogout;
    private javax.swing.JList<Book> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables


}
    

