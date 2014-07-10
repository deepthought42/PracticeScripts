var board = ['','','','','','','','',''];
var players = ['X','O'];			 
var turn = 0;


function move(board, id, turn){

	if(isSpaceFree(board, id)){
		board[id] = players[turn%2];
	}
	
	return board;
}

function getPotentialMoves(board){
	var positions = [];
	for(var row = 0; row < board.length; row++){
		if( isSpaceFree(board, row)){
			positions.push(row);
		}
	}
	return positions;
}


function printBoard(board){
	var boardString = "";
	var temp_str;
	for(var row = 0; row < board.length; row++){
		temp_str = board[row] ? board[row] : " ";
		boardString += temp_str;
		if((row+1)%3 === 0) 
			boardString += "\n";
	}
	console.log(boardString);
}


function isWinner(board, value){
	return (board[0] === value && board[1] === value && board[2] === value)
	|| (board[3] === value && board[4] === value && board[5] === value)
	|| (board[6] === value && board[7] === value && board[8] === value)
	|| (board[0] === value && board[3] === value && board[6] === value)
	|| (board[1] === value && board[4] === value && board[7] === value)
	|| (board[2] === value && board[5] === value && board[8] === value)
	|| (board[0] === value && board[4] === value && board[8] === value)
	|| (board[6] === value && board[4] === value && board[2] === value)
}

function isSpaceFree(board, row){
	//Return true if the passed move is free on the passed board.
	return board[row] === '';
}

function hasMoreMoves(board){
	for(var row = 0; row < board.length; row++){
		if(board[row] === ''){
			return true;
		}
	}
	return false;
}
	
function togglePlayerBackground(){
	if(turn%2 === 0){
		$('.player').first().css('background-color','red');
		$('.player').last().css('background-color','white');
	}
	else{			
		$('.player').first().css('background-color','white');
		$('.player').last().css('background-color','blue');
	}
}


function gameScore(board, playerId){
	if(isWinner(board, players[playerId])){
		$("#gameStatus").html(players[playerId] + " WINS!!!");
		return 10;
	}
	else if(isWinner(board, players[!playerId])){
		$("#gameStatus").html(players[!playerId] + " WINS!!!");
		return -10
	}
	else if(!hasMoreMoves(board)){
		$("#gameStatus").html("GAME OVER!!");
		return 0;
	}
	else {
		return -100;
	}
}


function minimax_naive(board, maximizingPlayer){
	var new_board = board.slice(0);
	var row = 0;
	
	if(!hasMoreMoves(new_board)){
		return gameScore(new_board, maximizingPlayer);
	}
	
	var moves = getPotentialMoves(new_board);
	if(maximizingPlayer){
		var bestVal = -100;
		var temp_val = 0;
		for(var i=0; i < moves.length; i++){
			temp_val = minimax_naive(move(new_board, moves[i] ,turn), false);
			if(bestVal < temp_val){
				bestVal = temp_val;
				row = moves[i];
			}
		}
		return row;
	}
	else {
		var bestVal = -100;
		var temp_val = 0;
		for(var i=0; i < moves.length; i++){
			temp_val = minimax_naive(move(new_board, moves[i], turn), true);
			if(bestVal < temp_val){
				bestVal = temp_val;
				row = moves[i];
			}
		}
		return row;
	}
}


function minimax_depth(board, maximizingPlayer, depth){
	var new_board = board.slice(0);
	var row = 0;
	
	if(!hasMoreMoves(new_board)|| gameScore(new_board, maximizingPlayer) !== -100){
		return gameScore(new_board, maximizingPlayer)/depth;
	}
	
	var moves = getPotentialMoves(new_board);
	if(maximizingPlayer){
		var bestVal = -100;
		var temp_val = 0;
		for(var i=0; i < moves.length; i++){
			temp_val = minimax_depth(move(new_board, moves[i] ,turn), false, depth+1);
			if(bestVal < temp_val){
				bestVal = temp_val;
				row = moves[i];
			}
		}
	}
	else {
		var bestVal = -100;
		var temp_val = 0;
		for(var i=0; i < moves.length; i++){
			temp_val = minimax_depth(move(new_board, moves[i], turn), true, depth+1);
			if(bestVal < temp_val){
				bestVal = temp_val;
				row = moves[i];
			}
		}
	}
	return row;
}


function minimax_aggressive_depth(board, maximizingPlayer, depth){
	var new_board = board.slice(0);
	var row = 0;
	
	if(!hasMoreMoves(new_board) || gameScore(new_board, maximizingPlayer) !== -100){
		return (gameScore(new_board, maximizingPlayer))/depth;
	}	
	var moves = getPotentialMoves(new_board);
	if(maximizingPlayer){
		var bestVal = -100;
		var temp_val = 0;
		for(var i=0; i < moves.length; i++){
			temp_val = minimax_aggressive_depth(move(new_board, moves[i] ,turn), false, depth+1);

			if(bestVal < temp_val){
				bestVal = temp_val;
				row = moves[i];
			}
		}
	}
	else {
		var bestVal = -100;
		var temp_val = 0;
		for(var i=0; i < moves.length; i++){
			temp_val = minimax_aggressive_depth(move(new_board, moves[i], turn), true, depth+1);
			if(bestVal < temp_val){
				bestVal = temp_val;
				row = moves[i];
			}
		}
	}
	return row;
}

$(document).ready(function(){
	while(gameScore(board, turn%2) === -100){
		var row1 = minimax_aggressive_depth(board, turn%2, 0);
		board = move(board, row1, turn);
		$("#"+row1).html("<span class='piece " + players[turn%2] + "'>" + players[turn%2] + "</span>");
		++turn;
		
		console.log("pick "+turn%2+" : " + row1);
		
		if(gameScore(board, turn%2) === -100){
			var row2 = minimax_aggressive_depth(board, turn%2, 0);
			printBoard(board);
			board = move(board, row2, turn);
			$("#"+row2).html("<span class='piece " + players[turn%2] + "'>" + players[turn%2] + "</span>");
			++turn;
		}
	}
		
	$("td").click( function() {
		if(gameScore(board, turn%2) === -100){
			board = move(board, $(this).attr('id'), turn);
			$(this).html("<span class='piece " + players[turn%2] + "'>" + players[turn%2] + "</span>");
			++turn;
			var row = minimax_aggressive_depth(board, turn%2, 0);
			
			if(gameScore(board, turn%2) === -100){
				board = move(board, row, turn);
				$("#"+row).html("<span class='piece " + players[turn%2] + "'>" + players[turn%2] + "</span>");
				++turn;
			}

			togglePlayerBackground();
			printBoard(board);
		}
	});
	
	$('#reset').click(function(){
		board = ['','','','','','','','',''];
		
		$('td').html('');
		turn = 0;
		togglePlayerBackground();
	});
});
