package com.codeinbp.telegrambot;

import net.codecrete.qrbill.generator.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@SpringBootApplication
public class TelegrambotApplication {
	 //

	public static void main(String[] args) throws TelegramApiException {

		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		ExampleBot myBot = new ExampleBot();

		botsApi.registerBot(myBot);




		//SpringApplication.run(TelegrambotApplication.class, args);
/*
		// Setup bill
		Bill bill = new Bill();
		bill.setAccount("CH4431999123000889012");
		bill.setAmountFromDouble(200.95);
		bill.setCurrency("EUR");

		// Set creditor
		Address creditor = new Address();
		creditor.setName("Robert Schneider AG");
		creditor.setAddressLine1("Rue du Lac 1268/2/22");
		creditor.setAddressLine2("2501 Biel");
		creditor.setCountryCode("CH");
		bill.setCreditor(creditor);

		// more bill data
		bill.setReference("210000000003139471430009017");
		bill.setUnstructuredMessage("Abonnement für 2020");

		// Set debtor
		Address debtor = new Address();
		debtor.setName("Pia-Maria Rutschmann-Schnyder");
		debtor.setAddressLine1("Grosse Marktgasse 28");
		debtor.setAddressLine2("9400 Rorschach");
		debtor.setCountryCode("CH");
		bill.setDebtor(debtor);

		// Set output format
		BillFormat format = bill.getFormat();
		format.setGraphicsFormat(GraphicsFormat.SVG);
		format.setOutputSize(OutputSize.QR_BILL_ONLY);
		format.setLanguage(Language.DE);

		// Generate QR bill
		byte[] svg = QRBill.generate(bill);

		// Save QR bill
		Path path = Paths.get("qrbill.svg");
		try {
			Files.write(path, svg);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		https://github.com/manuelbl/SwissQRBill
		System.out.println("QR bill saved at " + path.toAbsolutePath()); */
	}
}
