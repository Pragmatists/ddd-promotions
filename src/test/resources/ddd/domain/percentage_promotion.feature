Feature: Percentage discount promotion

	Background:
		Given there is following Price List:
		| Product    	| Price 	   	|
		| Magical Robe 	|         10,49 |
		| Enchanted Hat | 		   5,00	|
		| Smoking Pipe	|		  23,39 |	 

	Scenario: Get discount on every item
		When I puchase "Magical Robe" and "Enchanted Hat"
		And apply promotion "10% discount"
		Then I should get:
		| Product    	| Price 	   	|
		| Magical Robe 	|          9,49 |
		| Enchanted	Hat | 		   4,00	|
		| Total			|		  13,49 |
		
		 