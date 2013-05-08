package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import server.ServerInterface;

import model.Village;
import model.buildings.Building;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class BuildingGUI extends JFrame {

	private JPanel contentPane;
	private JLabel stufe; 	
	
	private int needRes1;
	private int needRes2;
	private int needRes3;
	private int needRes4;
	
	public BuildingGUI(final ServerInterface impl, final Building building, final Village vil) {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300,200,300,200);
		setTitle(building.getName());
		setVisible(true);
		setModalExclusionType(null);

		needRes1 = building.getNeededRes()[building.getCurrentLevel()][0];
		needRes2 = building.getNeededRes()[building.getCurrentLevel()][1];
		needRes3 = building.getNeededRes()[building.getCurrentLevel()][2];
		needRes4 = building.getNeededRes()[building.getCurrentLevel()][3];
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Gebaeude: " + building.getName());
		panel.add(lblName);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnDowngrade = new JButton("Downgrade");
		if(building.getCurrentLevel()>0) {
			btnDowngrade.setEnabled(true);
		} else {
			btnDowngrade.setEnabled(false);
		}
		
		btnDowngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int in = Integer.parseInt(stufe.getText());
				if(in>0) {
					in--;
				}
				stufe.setText(Integer.toString(in));
				try {
					impl.downgradeBuilding(vil.getX_koord(), vil.getY_koord(), building.getId());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		panel_1.add(btnDowngrade);
		
		JButton btnUpgrade = new JButton("Upgrade");
		if(needRes1<=vil.getRes1() && needRes2<=vil.getRes2() && needRes3<=vil.getRes3() && needRes4<=vil.getRes4()) {
			btnUpgrade.setEnabled(true);
		} else {
			btnUpgrade.setEnabled(false);
		}
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int in = Integer.parseInt(stufe.getText());
				if(in<building.getMaxLevel()) {
					in++;
				}
				stufe.setText(Integer.toString(in));
				try {
					impl.upgradeBuilding(vil.getX_koord(), vil.getY_koord(), building.getId());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
			}
		});
		panel_1.add(btnUpgrade);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblStufe = new JLabel("Stufe");
		
		stufe = new JLabel(Integer.toString(building.getCurrentLevel()));
		
		JLabel lblRes = new JLabel("Res1");
		
		JLabel label = new JLabel(Integer.toString(needRes1));
		
		JLabel lblRes_1 = new JLabel("Res2");
		
		JLabel label_1 = new JLabel(Integer.toString(needRes2));
		
		JLabel lblRes_2 = new JLabel("Res3");
		
		JLabel label_2 = new JLabel(Integer.toString(needRes3));
		
		JLabel lblRes_3 = new JLabel("Res4");
		
		JLabel label_3 = new JLabel(Integer.toString(needRes4));
		
		JLabel lblDauer = new JLabel("Dauer:");
		
		JLabel label_4 = new JLabel(Integer.toString(building.getNeededTime()[building.getCurrentLevel()]));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStufe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stufe)
					.addGap(66)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblRes_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblRes)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label)))
							.addGap(69)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblRes_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblRes_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(55)
							.addComponent(lblDauer)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStufe)
						.addComponent(stufe)
						.addComponent(lblRes)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(lblRes_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRes_2)
						.addComponent(label_2)
						.addComponent(lblRes_3)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDauer)
						.addComponent(label_4))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
	}

}
