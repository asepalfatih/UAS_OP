import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Bangunan{
    protected double panjang;
    protected double lebar;

    public Bangunan(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    public abstract double hitungLuas();
}



class Rumah extends Bangunan{
    private double tinggi;

    public Rumah(double panjang, double lebar, double tinggi){
        super(panjang,lebar);
        this.tinggi =tinggi;
    }

    public double hitungLuas(){
        return panjang*lebar*tinggi;
    }
}

class Gedung extends Bangunan{
    private int jumlahLantai;

    public Gedung(double panjang, double lebar, int jumlahLantai){
        super(panjang, lebar);
        this.jumlahLantai = jumlahLantai;
    }
    public double hitungLuas(){
        return panjang*lebar*jumlahLantai;
    }

}

class LuasBangunanGUI extends JFrame{
    private JLabel lblPanjang,lblLebar,lblLuas;
    private JTextField txtPanjang, txtLebar;
    private JRadioButton rbRumah,rbGedung;
    private ButtonGroup bgJenisBangunan;
    private JButton btnHitung;

    public LuasBangunanGUI(){
        setTitle("Menghitung Luas Banguanan");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        lblPanjang = new JLabel("Panjang : ");
        add(lblPanjang);

        txtPanjang = new JTextField();
        add(txtPanjang);

        lblLebar = new JLabel("Lebar : ");
        add(lblLebar);

        txtLebar = new JTextField();
        add(txtLebar);

        rbRumah = new JRadioButton("Rumah");
        rbGedung = new JRadioButton("Gedung");
        bgJenisBangunan = new ButtonGroup();
        bgJenisBangunan.add(rbRumah);
        bgJenisBangunan.add(rbGedung);
        add(rbRumah);
        add(rbGedung);

        lblLuas = new JLabel("Luas : ");
        add(lblLuas);

        btnHitung = new JButton("Hitung : ");
        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double panjang = Double.parseDouble(txtPanjang.getText());
                double lebar = Double.parseDouble(txtLebar.getText());

                if(rbRumah.isSelected()){
                    double tinggi = Double.parseDouble(JOptionPane.showInputDialog("Masukan tinggi Rumah : "));

                    Rumah rumah = new Rumah(panjang, lebar, tinggi);
                    lblLuas.setText("Luas : " + rumah.hitungLuas());
                }else if(rbGedung.isSelected()){
                    int jumlahLantai = Integer.parseInt(JOptionPane.showInputDialog("Masukan Jumlah Lantai Gedung : "));

                    Gedung gedung = new Gedung(panjang, lebar, jumlahLantai);

                    lblLuas.setText("Luas : " + gedung.hitungLuas());
                }else{
                    JOptionPane.showMessageDialog(null, "silahkan pilih jenis BAngunan");
                }
            }
        });
        add(btnHitung);
    }
}

