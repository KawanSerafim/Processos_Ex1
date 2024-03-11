package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	public static void main (String [] args) {
		RedesController redes = new RedesController();
		
		int opc = 0;
		while (opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n" +
					"1 - Retornar adaptador de rede e IPv4.\n" +
					"2 - Retornar a média do ping.\n" +
					"9 - Sair."));
			switch (opc) {
				case 1:
					redes.ip();
					break;
				case 2:
					redes.ping();
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Saindo...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção não identificada... Digite novamente.");
			}
		}
	}
}
