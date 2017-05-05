package com.jitesh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		
		Trader raul=new Trader("Raoul", "Cambridge");
		Trader mario=new Trader("Mario", "Milan");
		Trader alan=new Trader("Alan", "Cambridge");
		Trader brian=new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions=Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raul, 2012, 1000),
				new Transaction(raul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)



				
				);

		List<Transaction> result=transactions.stream().filter(t -> t.getYear()==2011)
				.sorted((a,b)->new Integer(a.getValue()).compareTo(new Integer(b.getValue())))
				.collect(Collectors.toList());
		System.out.println(result);
		
		List<String> resultList=transactions.stream().map(t->t.getTrader().getCity()).distinct().collect(Collectors.toList());
		System.out.println(resultList);
		
		resultList=transactions.stream().map(t->t.getTrader()).filter(t->t.getCity().equals("Cambridge"))
		.sorted(Comparator.comparing(Trader::getName)).map(t->t.getName()).distinct().collect(Collectors.toList());
		System.out.println(resultList);

		boolean flag=transactions.stream().map(t->t.getTrader()).anyMatch(t->t.getCity().equals("Milan"));
		System.out.println(flag);
		
		result=transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).collect(Collectors.toList());
		System.out.println(result);
		
		Optional<Transaction> t=transactions.stream().max(Comparator.comparing(Transaction::getValue));
		System.out.println(t.get());
	}

}
