#!/usr/bin/perl

my $square = sumOfSquare(1,100);
print "SQUARE::$square\n";

my $add = sum(1,100);
$add = square($add);
print "ADD::$add\n";

my $diff = $add - $square;
print "DIFF :: $diff\n";
exit;

sub square {
	my $val = shift;
	return $val*$val;
}

sub sumOfSquare {
	my ($start,$end) = @_;
	my $total = 0;
	for(my $i=$start;$i<=$end;$i++){
		$total += ($i*$i);
	}
	return $total;
}

sub sum {
	my ($start, $end) = @_;
	my $total = 0;
	for(my $i=$start;$i<=$end;$i++){
		$total += $i;
	}
	return $total;
}