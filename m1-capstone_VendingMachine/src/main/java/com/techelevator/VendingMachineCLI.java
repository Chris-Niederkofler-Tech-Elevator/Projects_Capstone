package com.techelevator;

import java.util.Scanner;



import com.techelevator.view.DisplayItemsStock;  
import com.techelevator.view.Machine; 

import com.techelevator.view.DisplayItemStock;
import com.techelevator.view.Machine;

import com.techelevator.view.Menu;

public class VendingMachineCLI { 
	
	

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String SUB_MENU_OPTION_1 = "Feed Money";
	private static final String SUB_MENU_OPTION_2 = "Purchase";
	private static final String SUB_MENU_OPTION_3 = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_1, SUB_MENU_OPTION_2, SUB_MENU_OPTION_3};
	private static final String MONEY_MENU_OPTION_1 = "Feed 1 Dollar";
	private static final String MONEY_MENU_OPTION_2 = "Feed 2 Dollars";
	private static final String MONEY_MENU_OPTION_5 = "Feed 5 Dollars";
	private static final String MONEY_MENU_OPTION_10 = "Feed 10 Dollars";
	private static final String [] MONEY_MENU_OPTIONS = { MONEY_MENU_OPTION_1, MONEY_MENU_OPTION_2, MONEY_MENU_OPTION_5, MONEY_MENU_OPTION_10 };
	
	private static Machine vendingMachine = null;


	

	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

			
				vendingMachine.displayItems();
			}else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					String submenuOptions = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if(submenuOptions.equals(SUB_MENU_OPTION_1)){
						String moneyMenuOption = (String)menu.getChoiceFromOptions(MONEY_MENU_OPTIONS);
						if(moneyMenuOption.equals(MONEY_MENU_OPTION_1)) {
						vendingMachine.feedMoney(1);
					}else if (moneyMenuOption.equals(MONEY_MENU_OPTION_2)) {
						vendingMachine.feedMoney(2);
						
					}else if (moneyMenuOption.equals(MONEY_MENU_OPTION_5)) {
						vendingMachine.feedMoney(3);
						
					}else if ((moneyMenuOption.equals(MONEY_MENU_OPTION_10))) {
						vendingMachine.feedMoney(4);
					}
					}else if (submenuOptions.equals(SUB_MENU_OPTION_2)) {
						vendingMachine.displayItems();
						System.out.println("Please input your Selection");
						Scanner selection = new Scanner(System.in);
						String inventoryControl = selection.nextLine();
						vendingMachine.control(inventoryControl);
					}else if(submenuOptions.equals(SUB_MENU_OPTION_3)) {

		

						vendingMachine.completeTransaction();
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		vendingMachine = new Machine(new DisplayItemsStock().importedCsv());

		

		cli.run();
	}
} 
