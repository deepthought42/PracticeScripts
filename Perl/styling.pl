#!/usr/bin/perl
use strict;
use warnings;

print "Starting styling program\n";
writeStyle();
print "Ending styling program\n";

sub writeStyle {
	my @content = readFile();
	my $styling = join("",@content);

	my $tag = "div";
	my $attrib = "color";
	my $style = getTag($tag,$styling);
	my $newAttribs = getAttribute($attrib,$style);
	print "Attribute: $attrib\n";
	my $newStyling = removeAttribute($attrib,$style);
	print "$newStyling\n";
	writeFile($styling,$newStyling,$tag);
}

sub getTag {
	my $tag = shift;
	my $block = shift;
	if($block =~ m/(\s*($tag)\s*\{(\n*.*?)*?\})/i) {
		my $style = $1;
		print "ending getTag() \n";
		return $1;
	}
	else{
		print "$tag not found\n";
	}
}

sub getAttribute {
	my $attrib = shift;
	my $block = shift;
	if ($block =~ m/(\s*($attrib).*)/) {
		return $1;
	} else {
		print "Could not find $attrib\n";
		return ""
	}
}


sub removeAttribute {
	my $attrib = shift;
	my $block = shift;
	my $blockCopy = $block;
	if ($block =~ s/(\s*($attrib).*)//) {
		return $block;
	} else {
		print "Could not find $attrib\n";
		return $blockCopy;
	}
}

sub getTag {
	my $tag = shift;
	my $block = shift;
	if($block =~ m/(\s*($tag)\s*\{(\n*.*?)*?\})/i) {
		my $style = $1;
		print "ending getTag() \n";
		return $1;
	}
	else{
		print "$tag not found\n";
	}
}

sub getID {
 my $id = shift;
 my $block;
	$block =~ /\s*\#($id)\s*\{(\n*.*?)*?\}/i;
}

sub getClass {
 my $class = shift;
 my $block;
	$block =~ /\s\.$class\s\{(\n*.*?)*?\}/i;
}

sub readFile {
	my $handle = open(CSS, "default.css") || die("Couldn't Open default.css");
	my @contents = <CSS>;
	close(CSS);
	return @contents;
}

sub writeFile {
	my $styling = shift;
	my $newStyle = shift;
	my $tag = shift;


	my $handle= open(CSSOUT, ">default.css") || die ("Couldn't open custom1.css");
	$^I =".bak";
	$styling =~ s/(\s*($tag)\s*\{(\n*.*?)*?\})/ $newStyle/;

	print CSSOUT "$styling\n";
	close(CSSOUT);
}





sub deleteTagStyle {
	my $tag = $_[0];
	#my $tagStyle = /^$tag\s*{.*}\/;
	#$tag =~ 's/'.$tagStyle.'/'.$tag.'\s\{\n\}\n/i';
}

sub writeTagStyle {
	#open a css file for styling
	my $handle = open STYLE, ">>custom.css";
	print "Please enter tag to create styling for.";
	if(! $handle){
		die "CSS styling file could not be opened.";
	} else {
		my $writeStyle = "y";
		while($writeStyle eq "y"){
			my $tagName = <STDIN>;
			chomp $tagName;
			print STYLE $tagName."{\n\n}\n";

			print "print another tag?(y/n) ";
			$writeStyle = <STDIN>;
			if($writeStyle =~ m/y/i){
				$writeStyle = "y";
			}else {
				last;
			}
		}
		close STYLE;
	}
}
