#!/usr/bin/perl -w
use IO::Socket;
use Net::hostent;

my $server - IO::Socket::INET->new(Proto		=> 'tcp',
									LocalPort   => 'finger',
									Listen		=> SOMAXCONN,
									Reuse		=> 1);
die "can't setup server" unless $server;

while($client = $server->accept()) {
	$client->autoflush(1);
	$hostinfo = gethostbyaddr($client->peeraddr);
	printf "[Connect from %s]\n", $hostinfo->name || $client->peerhost;
	my $command = client->getline();
	if	($command =~ /^uptime/) {$client->print('uptime');}
	elsif ($command =~ /^date/) {$client->print(scalar localtime, "\n");}
	else { $client->print("Unknown command\n");
		$client->close;
	}
}