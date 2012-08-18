#!/usr/bin/perl

my @numbersTracker =  (1..1000);
my @numbers;
my $val1 = 3;
my $val2 = 5;
my $prod1;
my $prod2;
for(my $i=1;$i<1001;$i++){
	$prod1 = $val1 * $i;
	$prod2 = $val2 * $i;

	if($numbersTracker[$prod1] != 1 && $prod1<1000){
		$numbersTracker[$prod1] = 1;
		push(@numbers, $prod1);
	}

	if(!($numbersTracker[$prod2] == 1) && $prod2<1000){
		$numbersTracker[$prod2] = 1;
		push(@numbers, $prod2);
	}
}

my $total = 0;
foreach my $num (@numbers){
	$total += $num;
}

print "total is :: $total \n";