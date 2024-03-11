package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	private String os() {
		
		return System.getProperty("os.name");
		
	}
	public void ip() {
		String nomeOS = os();
		
		if (nomeOS.contains("Windows")) {
			try {
				
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				String adap = "";
				while (linha != null) {
					if (linha.contains("Adaptador")) {
						adap = linha;
					}
					if (linha.contains("IPv4")) {
						System.out.println(adap + "\n" + linha);
					}
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (nomeOS.contains("Linux")) {
			
			try {
				Process p = Runtime.getRuntime().exec("ip addr");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				String adap = "";
				while (linha != null) {
					if (linha.contains("mtu")) {
						adap = linha;
					}
					if (linha.contains("inet ")) {
						System.out.println(adap + "\n" + linha);
					}
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Ainda não há uma versão para este sistema operacional...");
		}
	}
	
	public void ping() {
		String nomeOS = os();
		
		if (nomeOS.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = "";
				
				while (linha != null) {
					
					System.out.println("Calculando...");
					
					if ((linha.contains("M")&&(linha.contains("dia")))) {
						
						String[] media = linha.split(",");
						
						for (String palavra : media) {
							if (palavra.contains("dia")) {
								System.out.println("\n" + palavra);
							}
						}
						
					}
					
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (nomeOS.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = "";
				int cont = 1, cont2 = 1;;
				
				while (linha != null) {
					System.out.println("Calculando...");
					
					if ((linha.contains("avg"))) {
						
						String[] div1 = linha.split("=");
						
						for (String palavra : div1) {
							
							if (cont == 2) {
								
								String[] div2 = palavra.split("/");
								
								for (String palavra2 : div2) {
									
									if (cont2 == 2) {
										
										System.out.println("\n" + palavra2);
										
									}
									else if (cont2 < 2){
										cont2++;
									}
								}
							}
							else if (cont < 2) {
								cont++;
							}
						}
						
					}
					
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Ainda não há uma versão para este sistema operacional...");
		}
	}
}
