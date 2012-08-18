#!/usr/bin/perl
my $term1 = 1;
my $term2 = 1;
my $newTerm = 0;
while($newTerm < 4000000){
	$newTerm = $term1+$term2;
	$term1 = $term2;
	$term2 = $newTerm;
	
	if($newTerm%2 == 0 ){
		$total += $newTerm;
		print "even term :: $newTerm\n";
	}
}

print "Total of evens in Fibonacci sequence :: $total\n";