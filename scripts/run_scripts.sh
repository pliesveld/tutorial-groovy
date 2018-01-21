#!/bin/bash

inotifywait -r -m -e modify /scripts | 
while read path _ file; do 
	[[ $file =~ ^.*groovy$ ]] && {
        printf '********%-30s**************\n' "$file"
		echo '***************************' 
		groovy $path$file 2> /dev/null
	}
	[[ $file =~ ^.*js$ ]] && {
        printf '********%-30s**************\n' "$file"
		echo '***************************' 
		node $path$file
	}
	[[ $file =~ ^.*sh$ ]] && {
        printf '********%-30s**************\n' "$file"
		echo '***************************' 
		bash $path$file
	}
done


