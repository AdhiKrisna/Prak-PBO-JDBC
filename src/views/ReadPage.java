package views;

import connector.Connector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPage extends JFrame {
    JTable table;
    DefaultTableModel tableModel;
    JButton btnTambah, btnEdit, btnHapus;
    Integer selectedRow = null;
    Connector conn = new Connector();

    String[] columnNames = {"ID", "Nama", "Umur", "Agama", "Gender", "Skill"};

    public ReadPage() {
        setTitle("Data Biodata");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(null);

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 900, 600);
        add(scrollPane);

        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");

        btnTambah.setBounds(20, 680, 200, 40);
        btnEdit.setBounds(240, 680, 200, 40);
        btnHapus.setBounds(460, 680, 200, 40);

        add(btnTambah);
        add(btnEdit);
        add(btnHapus);

        loadData();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.getSelectedRow();
            }
        });

        btnTambah.addActionListener(e -> {
            // new InputPage();
            dispose();
        });

        btnEdit.addActionListener(e -> {
            if (selectedRow == null) {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu.");
                return;
            }

            int id = (int) table.getValueAt(selectedRow, 0);
            String nama = table.getValueAt(selectedRow, 1).toString();
            int umur = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());
            String agama = table.getValueAt(selectedRow, 3).toString();
            String gender = table.getValueAt(selectedRow, 4).toString();
            String skill = table.getValueAt(selectedRow, 5).toString();

            new EditPage(id, nama, umur, agama, gender, skill, this::refreshTable);
            // dispose();
        });

        btnHapus.addActionListener(e -> {
            if (selectedRow == null) {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu.");
                return;
            }

            int id = (int) table.getValueAt(selectedRow, 0);
            String nama = table.getValueAt(selectedRow, 1).toString();

            int konfirmasi = JOptionPane.showConfirmDialog(null,
                    "Yakin ingin menghapus " + nama + "?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);

            if (konfirmasi == JOptionPane.YES_OPTION) {
                conn.deleteData(id);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
                refreshTable();
            }
        });

        setVisible(true);
    }

    private void loadData() {
        ResultSet rs = conn.getAllData();

        try {
            while (rs.next()) {
                Object[] data = {
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getInt("umur"),
                    rs.getString("agama"),
                    rs.getString("gender"),
                    rs.getString("skills")
                };
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0); // clear rows
        loadData(); // reload data
        selectedRow = null;
    }
}
