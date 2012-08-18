#!/usr/bin/perl

my $val = 4;
do{
		$val++;
# 	print "VAL :: $val still looking\n";
}while(notLCM($val, 20));

# $array = toArray($val);
# use Data::Dumper;
# print "Array is :: ".Dumper($array);
exit;

sub notLCM{
	my ($val, $highestDivisor) = @_;
	for(my $j=1;$j<=$highestDivisor;$j++){
		if(($val % $j) != 0){
			my $rem = $val % $j;
			return 1;
		}
	}

	print "$val is the LCM!!! \n";
	return 0;
}

sub toArray{
	my $val = shift;
	@arr = [];
	for(my $i=0;$i<$val.length;$i++){
		$arr[$i] = substr($val,$i,1);
	}

	return \@arr;
}