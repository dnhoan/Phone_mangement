/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.IServices;

import BUS.Models.soluongbanmodel;

import BUS.Models.doanhthuModel;
import GUI.Services.DateService;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author LENOVO
 */
public class QuanLyThongKeCTL {

    private ThongKeServices thongKeServices = null;

    public QuanLyThongKeCTL() {
        this.thongKeServices = new ThongKeServicesImpl();
    }

    public void setdata1(JPanel jpnItem) {
        List<soluongbanmodel> listItem = thongKeServices.GetSLBan();

        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (soluongbanmodel x : listItem) {
                dataset.addValue(x.getSoluongban(), "số lượng",DateService.toString(x.getThang(), "dd-MM-yyyy"));
            }

            JFreeChart baChart = ChartFactory.createBarChart("Biểu đồ thống kê số lượng hàng bán được trong tháng".toUpperCase(),
                     "Ngày",
                    "Số lượng", dataset,
                    PlotOrientation.VERTICAL, false, true, false);
            ChartPanel chartPanel = new ChartPanel(baChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

    public void setdata2(JPanel jpnItem) {
        List<doanhthuModel> listItem = thongKeServices.GetDoanhThu();

        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (doanhthuModel x : listItem) {
                dataset.addValue(x.getDoanhthu(), "Doanh thu",DateService.toString(x.getThang(), "dd-MM-yyyy"));
            }

            JFreeChart baChart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu trong tháng".toUpperCase(),
                     "Ngày",
                    "Doanh thu", dataset,
                    PlotOrientation.VERTICAL, false, true, false);
            ChartPanel chartPanel = new ChartPanel(baChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
}
