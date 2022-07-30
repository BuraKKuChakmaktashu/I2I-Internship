#!/usr/bin/perl

use strict;
use warnings;

open(DATA, "<mySum.txt") or die "Couldn't open file file.txt, $!";


while(<DATA>) {
   if(index($_,'not') == -1){
	print WDATA "$_\n" ; 

 }
  open(WDATA,"+>>primeResults.txt") || die "Couldn't open file file.txt, $!";
   
}
