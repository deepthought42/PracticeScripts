#!/usr/bin/perl

my $val = 600851475143;
my @factors;
for(my $i=0;$i<$val;$i++){
	if($val%i == 0){
		push(@factors,($i));
		my $fact2 = $val/$i;
		if($fact2
	}
}

sub isPrime {
	my $val = shift;

	if($val % $i == 0){
		my $newVal = $val / $i;

		isPrime($newVal);
	}
	if(($val % 2)==0){
		return false;
	}
	elsif(($val % 3) == 0){
		return false;
	}
	elsif(($val % 5) == 0){
		return false;
	}
	elsif(($val % 7) == 0){
		return false;
	}
}