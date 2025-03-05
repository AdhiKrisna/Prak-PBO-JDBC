package views;
import javax.swing.*;
public class FormPage extends JFrame {

    JButton tombolSave, tombolEdit, tombolDelete, tombolOpen;
    JLabel labelNama, labelUmur, labelAgama, labelGender, labelSkill;
    JTextField fieldNama, fieldUmur;
    String[] namaAgama = {"Islam", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu"}; 
    ButtonGroup groupGender;
    JRadioButton radioLaki, radioPerempuan;
    JComboBox<String> comboAgama = new JComboBox<>(namaAgama);
    JCheckBox checkWeb, checkMobile, checkGame, checkUIUX, checkDS, checkAI;


    private void initComponents() {
        setTitle("Form Page");
        setSize(700, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Label
        labelNama = new JLabel("Nama");
        labelUmur = new JLabel("Umur");
        labelAgama = new JLabel("Agama");
        labelGender = new JLabel("Gender");
        labelSkill = new JLabel("Skill");

        // Text Field
        fieldNama = new JTextField();
        fieldUmur = new JTextField();

        //radio gender
        radioLaki = new JRadioButton("Laki-laki");
        radioPerempuan = new JRadioButton("Perempuan");
        groupGender = new ButtonGroup();
        groupGender.add(radioLaki);
        groupGender.add(radioPerempuan);

        // checkbox skill
        checkWeb = new JCheckBox("Web Developer");
        checkMobile = new JCheckBox("Mobile Developer");
        checkGame = new JCheckBox("Game Developer");
        checkUIUX = new JCheckBox("UI/UX Designer");
        checkDS = new JCheckBox("Data Scientist");
        checkAI = new JCheckBox("AI Engineer");

        add(labelNama);
        add(labelUmur);
        add(labelAgama);
        add(labelGender);
        add(labelSkill);
        add(fieldNama);
        add(fieldUmur);
        add(radioLaki);
        add(radioPerempuan);
        add(checkWeb);
        add(checkMobile);
        add(checkGame);
        add(checkUIUX);
        add(checkDS);
        add(checkAI);
        add(comboAgama);


    }
    private void setLayoutPosition(){
        labelNama.setBounds(10, 10, 120, 20);
        labelUmur.setBounds(10, 40, 120, 20);
        labelAgama.setBounds(10, 70, 120, 20);
        labelGender.setBounds(10, 100, 120, 20);
        labelSkill.setBounds(10, 130, 120, 20);

        fieldNama.setBounds(150, 10, 150, 20);
        fieldUmur.setBounds(150, 40, 150, 20);
        radioLaki.setBounds(150, 100, 100, 20);
        radioPerempuan.setBounds(250, 100, 100, 20);
        checkWeb.setBounds(150, 130, 150, 20);
        checkMobile.setBounds(300, 130, 150, 20);
        checkGame.setBounds(450, 130, 150, 20);
        checkUIUX.setBounds(150, 160, 150, 20);
        checkDS.setBounds(300, 160, 150, 20);
        checkAI.setBounds(450, 160, 150, 20);
        comboAgama.setBounds(150, 70, 150, 20);

    }

    public FormPage() {
        initComponents();
        setLayoutPosition();    

    }
}
