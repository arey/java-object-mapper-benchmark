# Labels
set title 'Java Object-to-Object mapping frameworks Performance Comparison'
set ylabel 'Object graph mapped per second'
set xlabel 'Mapping Framework'
set xtics nomirror rotate by -45


# Ranges
set autoscale

# Input
set datafile separator ','

# Output
set terminal png enhanced font "Verdana,9"
set output 'results.png'
set grid
set key off
set boxwidth 0.8 relative


# box style
set style line 1 lc rgb '#5C91CD' lt 1
set style fill solid

# remove top and right borders
set style line 2 lc rgb '#808080' lt 1
set border 3 back ls 2
set tics nomirror

plot 'results.csv' every ::1 using 0:5:xticlabels(8) with boxes ls 1,\
     'results.csv' every ::1 using 0:($5 + 1500):(sprintf("%d",$5)) with labels offset char 0,1