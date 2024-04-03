import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddStudent extends JPanel {
	private JTextField addname;
	private JTextField addid;
	private JTextField addphone;
	private JTextField addadd;
	private JTextField addfee;
	private JTextField addfeepermonth;
	private JTextField addemail;

	private JTextField addfeepaid;
	private JTextField uppass;
	private JTextField adddate;
	String path= null;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param frame 
	 * @param message 
	 */
	public AddStudent(JFrame frame, JTextArea message) {
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		JPanel panel_add = new JPanel();
		panel_add.setBackground(SystemColor.activeCaption);
		panel_add.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel_add);
		panel_add.setLayout(null);
		panel_add.setVisible(false);

		JLabel setname = new JLabel(" Name              :");
		setname.setBounds(22, 70, 85, 27);
		panel_add.add(setname);

		JLabel setid = new JLabel(" ID                   :");
		setid.setBounds(22, 100, 85, 27);
		panel_add.add(setid);

		JLabel setphone = new JLabel("Phone No        :");
		setphone.setBounds(22, 130, 85, 27);
		panel_add.add(setphone);

		JLabel setadd = new JLabel("Address          :");
		setadd.setBounds(22, 185, 85, 27);
		panel_add.add(setadd);

		addname = new JTextField();
		addname.setBounds(112, 73, 148, 20);
		panel_add.add(addname);
		addname.setColumns(10);

		addid = new JTextField();
		addid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addid.setBounds(112, 103, 148, 20);
		panel_add.add(addid);
		addid.setColumns(10);
		

		addphone = new JTextField();
		addphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addphone.setBounds(112, 133, 149, 20);
		panel_add.add(addphone);
		addphone.setColumns(10);

		addadd = new JTextField();
		addadd.setBounds(112, 188, 148, 20);
		panel_add.add(addadd);
		addadd.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Course            :");
		lblNewLabel_7.setBounds(22, 234, 85, 27);
		panel_add.add(lblNewLabel_7);

		Choice addcourse = new Choice();
		addcourse.setBounds(112, 240, 148, 20);
		addcourse.add("ADCA");
		addcourse.add("DCA");
		addcourse.add("DTP");
		addcourse.add("TALLY");
		addcourse.add("DFA");
		addcourse.add("ADCA+");
		addcourse.add("HINDI TYPING");
		addcourse.add("ENGLISH TYPING");
		addcourse.add("C++");
		addcourse.add("INTERNET");
		panel_add.add(addcourse);

		Checkbox jan = new Checkbox("January");
		jan.setBounds(319, 70, 95, 22);
		panel_add.add(jan);

		Checkbox feb = new Checkbox("February");
		feb.setBounds(319, 100, 95, 22);
		panel_add.add(feb);

		Checkbox mar = new Checkbox("March");
		mar.setBounds(319, 130, 95, 22);
		panel_add.add(mar);

		Checkbox apr = new Checkbox("April");
		apr.setBounds(319, 160, 95, 22);
		panel_add.add(apr);

		Checkbox my = new Checkbox("May");
		my.setBounds(319, 190, 95, 22);
		panel_add.add(my);

		Checkbox jun = new Checkbox("June");
		jun.setBounds(319, 218, 95, 22);
		panel_add.add(jun);

		Checkbox jul = new Checkbox("July");
		jul.setBounds(319, 246, 95, 22);
		panel_add.add(jul);

		Checkbox aug = new Checkbox("August");
		aug.setBounds(319, 274, 95, 22);
		panel_add.add(aug);

		Checkbox sep = new Checkbox("September");
		sep.setBounds(319, 302, 95, 22);
		panel_add.add(sep);

		Checkbox oct = new Checkbox("October");
		oct.setBounds(319, 330, 95, 22);
		panel_add.add(oct);

		Checkbox nov = new Checkbox("November");
		nov.setBounds(319, 358, 95, 22);
		panel_add.add(nov);

		Checkbox dec = new Checkbox("December");
		dec.setBounds(319, 386, 95, 22);
		panel_add.add(dec);

		Label label = new Label("Total Fee         :");
		label.setBounds(22, 292, 85, 27);
		panel_add.add(label);

		addfee = new JTextField();
		addfee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addfee.setBounds(112, 292, 148, 20);
		panel_add.add(addfee);
		addfee.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Fee Per Month :");
		lblNewLabel_8.setBounds(22, 325, 85, 27);
		panel_add.add(lblNewLabel_8);

		addfeepermonth = new JTextField();
		addfeepermonth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addfeepermonth.setBounds(111, 328, 149, 20);
		panel_add.add(addfeepermonth);
		addfeepermonth.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Course Duration:");
		lblNewLabel_9.setBounds(22, 259, 85, 27);
		panel_add.add(lblNewLabel_9);

		Choice choice_duration = new Choice();
		choice_duration.setBounds(112, 266, 148, 20);
		panel_add.add(choice_duration);
		choice_duration.add("1 Month");
		choice_duration.add("2 Month");
		choice_duration.add("3 Month");
		choice_duration.add("4 Month");
		choice_duration.add("5 Month");
		choice_duration.add("6 Month");
		choice_duration.add("7 Month");
		choice_duration.add("8 Month");
		choice_duration.add("9 Month");
		choice_duration.add("10 Month");
		choice_duration.add("11 Month");
		choice_duration.add("12 Month");

		JLabel lblNewLabel1 = new JLabel("Batch-Time  :");
		lblNewLabel1.setBounds(22, 209, 85, 27);
		panel_add.add(lblNewLabel1);

		Choice addtime = new Choice();
		addtime.setBounds(112, 214, 148, 20);
		panel_add.add(addtime);
		addtime.add("6:00 AM-7:00 AM");
		addtime.add("7:00 AM-8:00 AM");
		addtime.add("8:00 AM-9:00 AM");
		addtime.add("9:00 AM-10:00 AM");
		addtime.add("10:00 AM-11:00 AM");
		addtime.add("11:00 AM-12:00 PM");
		addtime.add("12:00 PM-1:00 PM");
		addtime.add("1:00 PM-2:00 PM");
		addtime.add("2:00 PM-3:00 PM");
		addtime.add("3:00 PM-4:00 PM");
		addtime.add("4:00 PM-5:00 PM");
		addtime.add("5:00 PM-6:00 PM");
		addtime.add("6:00 PM-7:00 PM");
		
		JLabel lblAdmissionDate1 = new JLabel("Admission Date :");
		lblAdmissionDate1.setBounds(22, 386, 85, 27);
		panel_add.add(lblAdmissionDate1);
		
		JTextField adddate = new JTextField();
		adddate.setBounds(111, 386, 149, 20);
		panel_add.add(adddate);
		adddate.setText(java.time.LocalDate.now().toString());
		String path = null;
		JButton addstudent = new JButton("SAVE");
		addstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String name = addname.getText();
					int id = Integer.parseInt(addid.getText());
					String phone = addphone.getText();
					String add = addadd.getText();
					String course = addcourse.getItem(addcourse.getSelectedIndex());
					String duration = choice_duration.getItem(choice_duration.getSelectedIndex());
					String fee = addfee.getText();
					String feepermonth = addfeepermonth.getText();
					String email = addemail.getText();
					String time = addtime.getItem(addtime.getSelectedIndex());
					String feepaid = addfeepaid.getText();
					if(addfeepaid.getText().isBlank()) {
						feepaid = "0";
					}
					int january = (jan.getState()) ? 1 : 0;
					int february = (feb.getState()) ? 1 : 0;
					int march = mar.getState() ? 1 : 0;
					int april = apr.getState() ? 1 : 0;
					int may = my.getState() ? 1 : 0;
					int june = jun.getState() ? 1 : 0;
					int july = jul.getState() ? 1 : 0;
					int august = aug.getState() ? 1 : 0;
					int september = sep.getState() ? 1 : 0;
					int october = oct.getState() ? 1 : 0;
					int november = nov.getState() ? 1 : 0;
					int december = dec.getState() ? 1 : 0;
					String date =adddate.getText();

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					File file = new File(path);
					InputStream in = new FileInputStream(file);
					PreparedStatement pstmt = connection.prepareStatement(
							"INSERT INTO shashi(`id`, `name`, `phone`, `add`, `course`, `courseduration`, `totalfee`, `feepermonth`, `jan`, `feb`, `march`, `april`, `may`, `june`, `july`, `august`, `september`, `october`, `november`, `december`, `email`, `image`, `time`, `feepaid`, `date`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, phone);
					pstmt.setString(4, add);
					pstmt.setString(5, course);
					pstmt.setString(6, duration);
					pstmt.setString(7, fee);
					pstmt.setString(8, feepermonth);
					pstmt.setInt(9, january);
					pstmt.setInt(10, february);
					pstmt.setInt(11, march);
					pstmt.setInt(12, april);
					pstmt.setInt(13, may);
					pstmt.setInt(14, june);
					pstmt.setInt(15, july);
					pstmt.setInt(16, august);
					pstmt.setInt(17, september);
					pstmt.setInt(18, october);
					pstmt.setInt(19, november);
					pstmt.setInt(20, december);
					pstmt.setString(21, email);
					pstmt.setBinaryStream(22, in, (int) file.length());
					pstmt.setString(23, time);
					pstmt.setString(24, feepaid);
					pstmt.setString(25, date);
					pstmt.executeUpdate();
					message.setText("Data Saved Done!");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Please Fill All Details Carefully!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				addid.setText("");
				addname.setText("");
				addphone.setText("");
				addadd.setText("");
				addfee.setText("");
				addfeepermonth.setText("");
				addemail.setText("");
				jan.setState(false);
				feb.setState(false);
				mar.setState(false);
				apr.setState(false);
				my.setState(false);
				jun.setState(false);
				jul.setState(false);
				aug.setState(false);
				sep.setState(false);
				oct.setState(false);
				nov.setState(false);
				dec.setState(false);
				addfeepaid.setText("");

			}
		});
		addstudent.setBounds(252, 470, 121, 38);
		panel_add.add(addstudent);

		JLabel lblNewLabel12 = new JLabel("Email               :");
		lblNewLabel12.setBounds(22, 160, 85, 27);
		panel_add.add(lblNewLabel12);

		addemail = new JTextField();
		addemail.setColumns(10);
		addemail.setBounds(111, 162, 149, 20);
		panel_add.add(addemail);

		JLabel addimg = new JLabel("");
		addimg.setBounds(417, 70, 160, 200);
		panel_add.add(addimg);
		addimg.setBorder(border);
		

		JButton browse = new JButton("SELECT IMAGE");
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					path(fc.getSelectedFile().getAbsolutePath());
					BufferedImage img;

					try {
						img = ImageIO.read(fc.getSelectedFile());
						ImageIcon imageIcon = new ImageIcon(fitimage(img, addimg.getWidth(), addimg.getHeight()));
						addimg.setIcon(imageIcon);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // it must be an image file, otherwise you'll get an exception

				}
			}
		});
		browse.setBounds(420, 274, 158, 27);
		panel_add.add(browse);
		
		JLabel lblfeepaid = new JLabel("Fee Paid          :");
		lblfeepaid.setBounds(22, 358, 85, 27);
		panel_add.add(lblfeepaid);
		
		addfeepaid = new JTextField();
		addfeepaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addfeepaid.setColumns(10);
		addfeepaid.setBounds(111, 358, 149, 20);
		panel_add.add(addfeepaid);
		
		
	}
	private Image fitimage(Image img, int w, int h) {
		BufferedImage resizedimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedimage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		return resizedimage;
	}
	public void path(String a) {
		path = a;
	}

}
