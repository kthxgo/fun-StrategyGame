package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Village;

import server.ServerInterface;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField;
	
	private JLabel lblRes1;
	private JLabel lblRes2;
	private JLabel lblRes3;
	private JLabel lblRes4;
	
	
	private JLabel lblDorfname;
	private JLabel lblKoordinaten;
	
	private Village vil;
	
	public GUI(final ServerInterface impl) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,200,500,350);
		this.setTitle("Game");
		this.setVisible(true);
		this.setModalExclusionType(null);
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblRes = new JLabel("Res1:");
		panel.add(lblRes);
		
		lblRes1 = new JLabel("00");
		panel.add(lblRes1);
		
		JLabel lblRes_1 = new JLabel("Res2:");
		panel.add(lblRes_1);
		
		lblRes2 = new JLabel("00");
		panel.add(lblRes2);
		
		JLabel lblRes_2 = new JLabel("Res3:");
		panel.add(lblRes_2);
		
		lblRes3 = new JLabel("00");
		panel.add(lblRes3);
		
		JLabel lblRes_3 = new JLabel("Res4:");
		panel.add(lblRes_3);
		
		lblRes4 = new JLabel("00");
		panel.add(lblRes4);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JLabel lblXkoord = new JLabel("X-Koord");
		
		NumberFormat intFormat = NumberFormat.getNumberInstance();
		formattedTextField = new JFormattedTextField(intFormat);
		formattedTextField.setValue(new Integer(0));
		formattedTextField.setColumns(3);
		
		
		JLabel lblYkoord = new JLabel("Y-Koord");
		
		formattedTextField_1 = new JFormattedTextField(intFormat);
		formattedTextField_1.setValue(new Integer(0));
		formattedTextField_1.setColumns(3);
		
		JButton btnGo = new JButton("go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					vil = impl.getVillagebyKoordinates(Integer.parseInt(formattedTextField.getText()), Integer.parseInt(formattedTextField_1.getText()));
					lblRes1.setText(vil.getRes1()/1000 + "(+" + vil.getRes1prod() + ")");
					lblRes2.setText(vil.getRes2()/1000 + "(+" + vil.getRes2prod() + ")");
					lblRes3.setText(vil.getRes3()/1000 + "(+" + vil.getRes3prod() + ")");
					lblRes4.setText(vil.getRes4()/1000 + "(+" + vil.getRes4prod() + ")");
					lblDorfname.setText(vil.getName());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
//				String str = formattedTextField.getText() + "/" + formattedTextField_1.getText();
//				lblKoordinaten.setText(str);
			}
		});
		

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(formattedTextField, Alignment.LEADING)
						.addComponent(lblXkoord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblYkoord, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(formattedTextField_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnGo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblXkoord)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYkoord)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGo)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		lblDorfname = new JLabel("Dorfname");
		
		lblKoordinaten = new JLabel("100/100");
		
		JLabel lblBuilding = new JLabel("Building1");
		lblBuilding.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new BuildingGUI(impl, vil.getBuildings().get(0), vil);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblDorfname)
							.addPreferredGap(ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
							.addComponent(lblKoordinaten))
						.addComponent(lblBuilding))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDorfname)
						.addComponent(lblKoordinaten))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBuilding)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
	}
}
