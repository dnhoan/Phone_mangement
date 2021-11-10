/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Services;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageService {

    public static Image getAppIcon() {
        URL url = ImageService.class.getResource("/icon/logo.png");
        return new ImageIcon(url).getImage();
    }

    public static ImageIcon readImage(String fileName, JLabel lblAnh) {
        File path = new File("logos", fileName);
        ImageIcon icon1 = new ImageIcon(path.getAbsolutePath());
        Image im = icon1.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), im.SCALE_SMOOTH));
        return icon;
    }

    public static void save(File src) {
        File dst = new File("logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }

        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("image\\", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
