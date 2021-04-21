#!/usr/bin/perl

use Benchmark;
$t0 = Benchmark->new;

%data = ('John Paul' => 45, 'Lisa' => 30, 'Kumar' => 40);
my @a = (1..100000);
for(@a){
	$x = int rand(3);
    if($x == 0) {
        $data{'John Paul'} = int rand(70);
    } elsif($x == 1) {
        $data{'Lisa'} = int rand(70);
    } else {
        $data{'Kumar'} = int rand(70);
    }
}

print "$data{'John Paul'}\n";
print "$data{'Lisa'}\n";
print "$data{'Kumar'}\n";

$t1 = Benchmark->new;
$td = timediff($t1, $t0);
print "the code took:",timestr($td),"\n";

use Benchmark;
$t0 = Benchmark->new;

$data2 = ('John Paul', 45, 'Lisa', 30, 'Kumar', 40);
my @a = (1..100000);
for(@a){
	$x = int rand(3);
    if($x == 0) {
        $data2[1] = int rand(70);
    } elsif($x == 1) {
        $data2[3] = int rand(70);
    } else {
        $data2[5] = int rand(70);
    }
}
print $data2;
$t1 = Benchmark->new;
$td = timediff($t1, $t0);
print "the code took:",timestr($td),"\n";
