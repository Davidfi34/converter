package igu;

import java.awt.EventQueue;

import javax.swing.*;

import org.json.JSONObject;

import models.CurrencyConversion;
import util.isNumeric;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoinsPage extends JFrame {

	private JPanel jPanel;
	private final JLabel lblConversor = new JLabel("Conversor de monedas");
	private JTextField inputAmount;
	private JLabel lblNewLabel_1;
	private JComboBox opTarget;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtRespose;


	/**
	 * Create the frame.
	 */
	public CoinsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 492);
		jPanel = new JPanel();
		jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jPanel);
		
		inputAmount = new JTextField();
		inputAmount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel_1 = new JLabel("Importe:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JComboBox opOriginal = new JComboBox();
		opOriginal.setModel(new DefaultComboBoxModel(new String[] {"AED - Dírham de los Emiratos Árabes Unidos", "AFN - Afganistán afgano", "ALL - Lek albanés", "AMD - Dram armenio", "ANG - Neth. Hormiga y florín", "AOA - Kwanza angoleño", "ARS - peso argentino", "AUD - Dólar australiano", "AWG - Florín de Aruba", "AZN - Manat de Azerbaiyán", "BAM - Descapotable bosnio", "BBD - Dólar de Barbados", "BDT - Taka bangladesí", "BGN - Lev búlgaro", "BHD - dinar de bahrein", "BIF - Franco de Burundi", "BMD - dólar bermudeño", "BND - Dólar de Brunéi", "BOB - boliviano boliviano", "BRL - Real brasileño", "BSD - dólar bahameño", "BTN - Bután Ngultrum", "BWP - Botsuana Pula", "BYN - rublo bielorruso", "BZD - Dólar de Belice", "CAD - Dolar canadiense", "CDF - franco congoleño", "CHF - Franco suizo", "CLP - peso chileno", "CNY - Yuan renminbi chino", "COP - peso colombiano", "CRC - Colón costarricense", "CVE - Escudo de Cabo Verde", "CYP - Libra chipriota", "CZK - corona checa", "DJF - Franco de Yibuti", "DKK - corona danesa", "DOP - peso dominicano", "DZD - dinar argelino", "EEK - corona estonia", "EGP - Libra egipcia", "ERN - Nafka de Eritrea", "ETB - Birr etíope", "EUR - Euro", "FJD - dólar fiyiano", "FKP - Islas Malvinas. Libra", "GBP - Libra británica", "GEL - Lari georgiano", "GHS - Cedi de Ghana", "GIP - Libra gibraltareña", "GMD - Gambia Dalasi", "GNF - Franco guineano", "GQE - Eqguinea Ekwele", "GTQ - guatemala quetzal", "GWP - guinea-bissau peso", "GYD - dólar guyanés", "HKD - Dolar de Hong Kong", "HNL - lempiras hondureñas", "HRK - Kuna croata", "HTG - gourde haitiano", "HUF - florín húngaro", "IDR - rupia indonesia", "ILS - Nuevo séquel israelí", "INR - Rupia india", "IQD - dinar iraquí", "IRR - rial iraní", "ISK - corona islandesa", "JMD - dólar jamaiquino", "JOD - dinar jordano", "JPY - Yen japonés", "KES - chelín keniano", "KGS - Kirguistán Som", "KHR - Riel camboyano", "KMF - franco comorano", "KRW - Corea del Sur ganó", "KWD - dinar kuwaití", "KYD - Islas Caimán. Dólar", "KZT - Tenge kazajo", "LAK - Kip laosiano", "LBP - Libra libanesa", "LKR - Rupia de Sri Lanka", "LRD - dólar liberiano", "LSL - lesoto loti", "LTL - Litas lituana", "LVL - Lat letón", "LYD - dinar libio", "MAD - Dírham marroquí", "MDL - Leu moldavo", "MGA - Ariary malgache", "MKD - Denar macedonio", "MMK - Kyat birmano", "MNT - mongolia tugrik", "MOP - Pataca de Macao", "MRO - Mauritania Ouguiya", "MRU - Mauritania Ouguiya", "MTL - lira maltesa", "MUR - Rupia de Mauricio", "MVR - Maldivas Rufiyaa", "MWK - Kwacha malauí", "MXN - peso mexicano", "MYR - Ringgit malayo", "MZN - Mozambique Metical", "NAD - dólar namibio", "NGN - nigeria naira", "NIO - Nicaragua Córdoba Oro", "NOK - corona noruega", "NPR - rupia nepalí", "NZD - Dolar de Nueva Zelanda", "OMR - Rial de Omán", "PAB - Panamá Balboa", "PEN - Perú Nuevo Sol", "PGK - Papúa Ng Kina", "PHP - peso filipino", "PKR - Rupia de Pakistán", "PLN - Nuevo zloty polaco", "PYG - guaraní paraguayo", "QAR - Rial catarí", "RON - leus rumanos", "RSD - dinar serbio", "RUB - Rublo ruso", "RWF - franco ruandés", "SAR - rial saudita", "SBD - Salomón es. Dólar", "SCR - Rupia de Seychelles", "SDG - Libra sudanesa", "SEK - Corona sueca", "SGD - Dolar de Singapur", "SHP - Libra de Santa Elena", "SIT - Tólar esloveno", "SKK - corona eslovaca", "SLL - Sierra L Leona", "SOS - chelín somalí", "SRD - Dólar de Surinam", "SSP - Libra sursudanesa", "STD - Santo Tomé Dobra", "STN - Santo Tomé Dobra", "SVC - El Salvador Colón", "SYP - Libra siria", "SZL - Lilangeni suazi", "THB - Baht tailandés", "TJS - Tayikistán Somoni", "TMT - Manat de Turkmenistán", "TND - dinar tunecino", "TOP - Tonga Panga", "TRY - Lira turca", "TTD - TrinidadTobago Dol.", "TWD - Nuevo dólar taiwanés", "TZS - chelín tanzano", "UAH - Grivna ucraniana", "UGX - Chelín ugandés", "USD - Dólar de los Estados Unidos", "UYU - peso uruguayo", "UZS - Suma de Uzbekistán", "VEF - Venezuela Bolivar Fuerte", "VES - Bolívar Soberano", "VND - vietnam dong", "VUV - Vanuatu Vatu", "WST - Tala de Samoa", "XAF - Cfa Franco Playa", "XCD - E. Dólar caribeño", "XOF - Franco Cfa Bceao", "XPF - franco CFP", "YER - rial yemení", "ZAR - Rand sudafricano", "ZMW - kwacha zambiano", "ZWL - dólar zimbabuense"}));
		opOriginal.setToolTipText("");
		
		opTarget = new JComboBox();
		opTarget.setModel(new DefaultComboBoxModel(new String[] {"AED - Dírham de los Emiratos Árabes Unidos", "AFN - Afganistán afgano", "ALL - Lek albanés", "AMD - Dram armenio", "ANG - Neth. Hormiga y florín", "AOA - Kwanza angoleño", "ARS - peso argentino", "AUD - Dólar australiano", "AWG - Florín de Aruba", "AZN - Manat de Azerbaiyán", "BAM - Descapotable bosnio", "BBD - Dólar de Barbados", "BDT - Taka bangladesí", "BGN - Lev búlgaro", "BHD - dinar de bahrein", "BIF - Franco de Burundi", "BMD - dólar bermudeño", "BND - Dólar de Brunéi", "BOB - boliviano boliviano", "BRL - Real brasileño", "BSD - dólar bahameño", "BTN - Bután Ngultrum", "BWP - Botsuana Pula", "BYN - rublo bielorruso", "BZD - Dólar de Belice", "CAD - Dolar canadiense", "CDF - franco congoleño", "CHF - Franco suizo", "CLP - peso chileno", "CNY - Yuan renminbi chino", "COP - peso colombiano", "CRC - Colón costarricense", "CVE - Escudo de Cabo Verde", "CYP - Libra chipriota", "CZK - corona checa", "DJF - Franco de Yibuti", "DKK - corona danesa", "DOP - peso dominicano", "DZD - dinar argelino", "EEK - corona estonia", "EGP - Libra egipcia", "ERN - Nafka de Eritrea", "ETB - Birr etíope", "EUR - Euro", "FJD - dólar fiyiano", "FKP - Islas Malvinas. Libra", "GBP - Libra británica", "GEL - Lari georgiano", "GHS - Cedi de Ghana", "GIP - Libra gibraltareña", "GMD - Gambia Dalasi", "GNF - Franco guineano", "GQE - Eqguinea Ekwele", "GTQ - guatemala quetzal", "GWP - guinea-bissau peso", "GYD - dólar guyanés", "HKD - Dolar de Hong Kong", "HNL - lempiras hondureñas", "HRK - Kuna croata", "HTG - gourde haitiano", "HUF - florín húngaro", "IDR - rupia indonesia", "ILS - Nuevo séquel israelí", "INR - Rupia india", "IQD - dinar iraquí", "IRR - rial iraní", "ISK - corona islandesa", "JMD - dólar jamaiquino", "JOD - dinar jordano", "JPY - Yen japonés", "KES - chelín keniano", "KGS - Kirguistán Som", "KHR - Riel camboyano", "KMF - franco comorano", "KRW - Corea del Sur ganó", "KWD - dinar kuwaití", "KYD - Islas Caimán. Dólar", "KZT - Tenge kazajo", "LAK - Kip laosiano", "LBP - Libra libanesa", "LKR - Rupia de Sri Lanka", "LRD - dólar liberiano", "LSL - lesoto loti", "LTL - Litas lituana", "LVL - Lat letón", "LYD - dinar libio", "MAD - Dírham marroquí", "MDL - Leu moldavo", "MGA - Ariary malgache", "MKD - Denar macedonio", "MMK - Kyat birmano", "MNT - mongolia tugrik", "MOP - Pataca de Macao", "MRO - Mauritania Ouguiya", "MRU - Mauritania Ouguiya", "MTL - lira maltesa", "MUR - Rupia de Mauricio", "MVR - Maldivas Rufiyaa", "MWK - Kwacha malauí", "MXN - peso mexicano", "MYR - Ringgit malayo", "MZN - Mozambique Metical", "NAD - dólar namibio", "NGN - nigeria naira", "NIO - Nicaragua Córdoba Oro", "NOK - corona noruega", "NPR - rupia nepalí", "NZD - Dolar de Nueva Zelanda", "OMR - Rial de Omán", "PAB - Panamá Balboa", "PEN - Perú Nuevo Sol", "PGK - Papúa Ng Kina", "PHP - peso filipino", "PKR - Rupia de Pakistán", "PLN - Nuevo zloty polaco", "PYG - guaraní paraguayo", "QAR - Rial catarí", "RON - leus rumanos", "RSD - dinar serbio", "RUB - Rublo ruso", "RWF - franco ruandés", "SAR - rial saudita", "SBD - Salomón es. Dólar", "SCR - Rupia de Seychelles", "SDG - Libra sudanesa", "SEK - Corona sueca", "SGD - Dolar de Singapur", "SHP - Libra de Santa Elena", "SIT - Tólar esloveno", "SKK - corona eslovaca", "SLL - Sierra L Leona", "SOS - chelín somalí", "SRD - Dólar de Surinam", "SSP - Libra sursudanesa", "STD - Santo Tomé Dobra", "STN - Santo Tomé Dobra", "SVC - El Salvador Colón", "SYP - Libra siria", "SZL - Lilangeni suazi", "THB - Baht tailandés", "TJS - Tayikistán Somoni", "TMT - Manat de Turkmenistán", "TND - dinar tunecino", "TOP - Tonga Panga", "TRY - Lira turca", "TTD - TrinidadTobago Dol.", "TWD - Nuevo dólar taiwanés", "TZS - chelín tanzano", "UAH - Grivna ucraniana", "UGX - Chelín ugandés", "USD - Dólar de los Estados Unidos", "UYU - peso uruguayo", "UZS - Suma de Uzbekistán", "VEF - Venezuela Bolivar Fuerte", "VES - Bolívar Soberano", "VND - vietnam dong", "VUV - Vanuatu Vatu", "WST - Tala de Samoa", "XAF - Cfa Franco Playa", "XCD - E. Dólar caribeño", "XOF - Franco Cfa Bceao", "XPF - franco CFP", "YER - rial yemení", "ZAR - Rand sudafricano", "ZMW - kwacha zambiano", "ZWL - dólar zimbabuense"}));
		opTarget.setToolTipText("AED - Dírham de los Emiratos Árabes Unidos\r\nAFN - Afganistán afgano\r\nALL - Lek albanés\r\nAMD - Dram armenio\r\nANG - Neth. Hormiga y florín\r\nAOA - Kwanza angoleño\r\nARS - peso argentino\r\nAUD - Dólar australiano\r\nAWG - Florín de Aruba\r\nAZN - Manat de Azerbaiyán\r\nBAM - Descapotable bosnio\r\nBBD - Dólar de Barbados\r\nBDT - Taka bangladesí\r\nBGN - Lev búlgaro\r\nBHD - dinar de bahrein\r\nBIF - Franco de Burundi\r\nBMD - dólar bermudeño\r\nBND - Dólar de Brunéi\r\nBOB - boliviano boliviano\r\nBRL - Real brasileño\r\nBSD - dólar bahameño\r\nBTN - Bután Ngultrum\r\nBWP - Botsuana Pula\r\nBYN - rublo bielorruso\r\nBZD - Dólar de Belice\r\nCAD - Dolar canadiense\r\nCDF - franco congoleño\r\nCHF - Franco suizo\r\nCLP - peso chileno\r\nCNY - Yuan renminbi chino\r\nCOP - peso colombiano\r\nCRC - Colón costarricense\r\nCVE - Escudo de Cabo Verde\r\nCYP - Libra chipriota\r\nCZK - corona checa\r\nDJF - Franco de Yibuti\r\nDKK - corona danesa\r\nDOP - peso dominicano\r\nDZD - dinar argelino\r\nEEK - corona estonia\r\nEGP - Libra egipcia\r\nERN - Nafka de Eritrea\r\nETB - Birr etíope\r\nEUR - Euro\r\nFJD - dólar fiyiano\r\nFKP - Islas Malvinas. Libra\r\nGBP - Libra británica\r\nGEL - Lari georgiano\r\nGHS - Cedi de Ghana\r\nGIP - Libra gibraltareña\r\nGMD - Gambia Dalasi\r\nGNF - Franco guineano\r\nGQE - Eqguinea Ekwele\r\nGTQ - guatemala quetzal\r\nGWP - guinea-bissau peso\r\nGYD - dólar guyanés\r\nHKD - Dolar de Hong Kong\r\nHNL - lempiras hondureñas\r\nHRK - Kuna croata\r\nHTG - gourde haitiano\r\nHUF - florín húngaro\r\nIDR - rupia indonesia\r\nILS - Nuevo séquel israelí\r\nINR - Rupia india\r\nIQD - dinar iraquí\r\nIRR - rial iraní\r\nISK - corona islandesa\r\nJMD - dólar jamaiquino\r\nJOD - dinar jordano\r\nJPY - Yen japonés\r\nKES - chelín keniano\r\nKGS - Kirguistán Som\r\nKHR - Riel camboyano\r\nKMF - franco comorano\r\nKRW - Corea del Sur ganó\r\nKWD - dinar kuwaití\r\nKYD - Islas Caimán. Dólar\r\nKZT - Tenge kazajo\r\nLAK - Kip laosiano\r\nLBP - Libra libanesa\r\nLKR - Rupia de Sri Lanka\r\nLRD - dólar liberiano\r\nLSL - lesoto loti\r\nLTL - Litas lituana\r\nLVL - Lat letón\r\nLYD - dinar libio\r\nMAD - Dírham marroquí\r\nMDL - Leu moldavo\r\nMGA - Ariary malgache\r\nMKD - Denar macedonio\r\nMMK - Kyat birmano\r\nMNT - mongolia tugrik\r\nMOP - Pataca de Macao\r\nMRO - Mauritania Ouguiya\r\nMRU - Mauritania Ouguiya\r\nMTL - lira maltesa\r\nMUR - Rupia de Mauricio\r\nMVR - Maldivas Rufiyaa\r\nMWK - Kwacha malauí\r\nMXN - peso mexicano\r\nMYR - Ringgit malayo\r\nMZN - Mozambique Metical\r\nNAD - dólar namibio\r\nNGN - nigeria naira\r\nNIO - Nicaragua Córdoba Oro\r\nNOK - corona noruega\r\nNPR - rupia nepalí\r\nNZD - Dolar de Nueva Zelanda\r\nOMR - Rial de Omán\r\nPAB - Panamá Balboa\r\nPEN - Perú Nuevo Sol\r\nPGK - Papúa Ng Kina\r\nPHP - peso filipino\r\nPKR - Rupia de Pakistán\r\nPLN - Nuevo zloty polaco\r\nPYG - guaraní paraguayo\r\nQAR - Rial catarí\r\nRON - leus rumanos\r\nRSD - dinar serbio\r\nRUB - Rublo ruso\r\nRWF - franco ruandés\r\nSAR - rial saudita\r\nSBD - Salomón es. Dólar\r\nSCR - Rupia de Seychelles\r\nSDG - Libra sudanesa\r\nSEK - Corona sueca\r\nSGD - Dolar de Singapur\r\nSHP - Libra de Santa Elena\r\nSIT - Tólar esloveno\r\nSKK - corona eslovaca\r\nSLL - Sierra L Leona\r\nSOS - chelín somalí\r\nSRD - Dólar de Surinam\r\nSSP - Libra sursudanesa\r\nSTD - Santo Tomé Dobra\r\nSTN - Santo Tomé Dobra\r\nSVC - El Salvador Colón\r\nSYP - Libra siria\r\nSZL - Lilangeni suazi\r\nTHB - Baht tailandés\r\nTJS - Tayikistán Somoni\r\nTMT - Manat de Turkmenistán\r\nTND - dinar tunecino\r\nTOP - Tonga Panga\r\nTRY - Lira turca\r\nTTD - TrinidadTobago Dol.\r\nTWD - Nuevo dólar taiwanés\r\nTZS - chelín tanzano\r\nUAH - Grivna ucraniana\r\nUGX - Chelín ugandés\r\nUSD - Dólar de los Estados Unidos\r\nUYU - peso uruguayo\r\nUZS - Suma de Uzbekistán\r\nVEF - Venezuela Bolivar Fuerte\r\nVES - Bolívar Soberano\r\nVND - vietnam dong\r\nVUV - Vanuatu Vatu\r\nWST - Tala de Samoa\r\nXAF - Cfa Franco Playa\r\nXCD - E. Dólar caribeño\r\nXOF - Franco Cfa Bceao\r\nXPF - franco CFP\r\nYER - rial yemení\r\nZAR - Rand sudafricano\r\nZMW - kwacha zambiano\r\nZWL - dólar zimbabuense");
		
		lblNewLabel_2 = new JLabel("De:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblNewLabel_3 = new JLabel("a:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      double confirm = JOptionPane.showConfirmDialog(null,
	                        "Desea salir?",
	                        "Menu", JOptionPane.YES_NO_OPTION);
	                if(confirm == 0 ) System.exit(0);
			}
		});
		
		
		
		JButton btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		           inputAmount.setText("");
	                txtRespose.setText("");

	                opOriginal.setSelectedIndex(0);
	                opTarget.setSelectedIndex(0);


				
			}
		});
		
		
		
		JButton btnConvert = new JButton("Convertir");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
                boolean isNumber = isNumeric.isPositiveNumber(inputAmount.getText());


                if (isNumber){
                    CurrencyConversion CyConversion = new CurrencyConversion();

                    Double input = Double.parseDouble(inputAmount.getText());
                    String opObj = opOriginal.getSelectedItem().toString().substring(0,3);
                    String opTarg = opTarget.getSelectedItem().toString().substring(0,3);

                    JSONObject result = CyConversion.getData(input, opObj, opTarg);

                    Double caculatedValue =  result.getDouble("conversion_result");
                    //String timeLastUpdate =  String.valueOf(result.getString("time_last_update_utc"));

                    txtRespose.setText(input +" "+ opObj +"  =  "+caculatedValue +" "+ opTarg );
                }else {
                    JOptionPane.showMessageDialog(null,
                            "error! Utiliza un número positivo.",
                            "Menu",JOptionPane.ERROR_MESSAGE,null);
                }
				
				
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Resultado");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtRespose = new JTextField();
		txtRespose.setHorizontalAlignment(SwingConstants.CENTER);
		txtRespose.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtRespose.setEditable(false);
		txtRespose.setColumns(10);
		
		GroupLayout gl_jPanel = new GroupLayout(jPanel);
		gl_jPanel.setHorizontalGroup(
			gl_jPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGap(246)
					.addComponent(lblConversor)
					.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_jPanel.createSequentialGroup()
					.addGroup(gl_jPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_jPanel.createSequentialGroup()
							.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel.createSequentialGroup()
									.addGap(154)
									.addComponent(btnExit)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnClear))
								.addGroup(gl_jPanel.createSequentialGroup()
									.addGap(161, 457, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addGap(79))
						.addGroup(Alignment.LEADING, gl_jPanel.createSequentialGroup()
							.addGap(141)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(inputAmount)
								.addComponent(txtRespose)
								.addComponent(opTarget, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(opOriginal, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConvert, Alignment.TRAILING))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_jPanel.setVerticalGroup(
			gl_jPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(lblConversor)
					.addGap(41)
					.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_jPanel.createSequentialGroup()
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(inputAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(opOriginal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(opTarget, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRespose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(39)
					.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConvert)
						.addComponent(btnClear)
						.addComponent(btnExit))
					.addGap(72))
		);
		lblConversor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel.setLayout(gl_jPanel);
	}
}
