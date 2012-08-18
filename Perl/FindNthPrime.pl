#!/usr/bin/perl

use Math::Complex;

print "INIT VARS...\n";
my $nthPrime;
my $totPrimes = 0;

print "STARTING PRIME SEARCH\n";
for(my $x=2;;$x++){
	if(isPrime($x)){
		$totPrimes++;
	}

	if($totPrimes == 10001){
		$nthPrime = $x;
# 		print "6th prime encountered\n";
		last;
	}
}
print "THE 10001st prime number is :: $nthPrime\n";

exit;

sub isPrime {
	my ($val) = @_;
	my $n = sqrt($val);

	if(($val%2) == 0 && $val != 2){
		return 0;
	}
	for( my $i = 3; $i<=$n; $i+=2){
		if(($val % $i) == 0){
			return 0;
		}
	}

	return 1;
}