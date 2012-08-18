#!/usr/bin/perl
use IO::Socket::INET

my($host, $username) = @ARGV;
my $socket = IO::Socket::INET->new(
							PeerAddr => $host,
							PeerPort => "finger"
						) or die $!;

$socket->print(qq($username\n));

while($_ = $socket->getline) {
	print;
}