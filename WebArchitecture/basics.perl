#!\usr\bin\perl
@a=(10,20,50,100);
@b=("red","blue","green");
@c=('A'...'Z');
@d=(10...20);
@color=qw(red blue green black);
@x=qw(10.5 20 13 04.3 5 6.6);
@sort_col=sort @x;
$first= shift @color;
$second= unshift (@color,"white");
print "values of both the array are:\na: @a \nb: @b \nc: @c \nd: @d \n";
print "colors: @color \n";
print "sorting : @sort_col \n";
print "first from color: $first \n";
print "second from color: $second \n";

#mixed datatype arrays are allowed
$size = scalar @a;
print "size of a: $size\n";
@rev = reverse @color;
print "reverse of color: @rev\n";

$last = pop @a;
print "last element of a: $last\n";
$what = push @a;
print "$what\n";

print "Heyy! How you doin'?\n";
$ans = <STDIN>;
$nans = chop($ans); #delete the last character
$nnans = chomp($ans);#delete the last \n otherwise does nothing
print "So, one fine day..\nJoey asked, \"How you doin'?\"\nShe replied, \"$nnans\"\n";
