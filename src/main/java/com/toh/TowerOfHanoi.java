package com.toh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerOfHanoi {

	//declared list of map to hold int type key value pair
	List<Map<Integer, Integer>> movementList;

	//Initialize moventList in TOH constructor
	public TowerOfHanoi() {
		movementList = new ArrayList<Map<Integer, Integer>>();
	}

	/**
	 * Process start by passing required values
	 * @param n
	 * @return
	 */
	public Map<Map<Integer, Integer>, Integer> startProcess(int n) {
		int a = 0, b = 1, c = 2;
		moveTower(n, a, c, b);
		return moveStatistics(a, b, c);
	}

	/**
	 * Recursive call for Bob movement to move disk fromPeg to toPeg
	 * @param height
	 * @param fromPeg
	 * @param toPeg
	 * @param withPeg
	 */
	public void moveTower(int height, int fromPeg, int toPeg, int withPeg) {

		if (height >= 1) {
			moveTower(height - 1, fromPeg, withPeg, toPeg);
			moveDisk(fromPeg, toPeg);
			moveTower(height - 1, withPeg, toPeg, fromPeg);
		}
	}

	/**
	 * Written logic to move disk from one rod to another
	 * @param fromPeg
	 * @param toPeg
	 */
	public void moveDisk(int fromPeg, int toPeg) {
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		tempMap.put(fromPeg, toPeg);
		movementList.add(tempMap);
	}

	/**
	 * This method is used to hold statistics of movement
	 * @param a rod a value
	 * @param b rod b value
	 * @param c rod c value
	 * @return Map<Map<Integer, Integer>, Integer> 
	 */
	public Map<Map<Integer, Integer>, Integer> moveStatistics(int a, int b, int c) {

		//created position map of map with integer value to hold pair with integer count
		Map<Map<Integer, Integer>, Integer> position = new HashMap<Map<Integer, Integer>, Integer>();
		int movementCount = movementList.size();
		for (int i = 0; i < movementCount - 1; i++) {
			
			//getting map paired of number from movement list
			Map<Integer, Integer> tempNthMap = movementList.get(i);
			Map<Integer, Integer> tempNth1Map = movementList.get(i + 1);
			
			int currFromPeg = 0, currToPeg = 0, nextFromPeg = 0;
			
			//getting key value and assign to variable like currFromPeg, curreTopeg etc.
			for (Map.Entry<Integer, Integer> entry : tempNthMap.entrySet()) {
				currFromPeg = entry.getKey();
				currToPeg = entry.getValue();
			}

			for (Map.Entry<Integer, Integer> entry : tempNth1Map.entrySet()) {
				nextFromPeg = entry.getKey();
			}

			//Create new map for currFromToMap and nextFromPeg
			Map<Integer, Integer> currFromToMap = new HashMap<Integer, Integer>();
			Map<Integer, Integer> nextFromToMap = new HashMap<Integer, Integer>();

			currFromToMap.put(currFromPeg, currToPeg);
			nextFromToMap.put(currToPeg, nextFromPeg);

			
			List<Map<Integer, Integer>> tempFromToPegList = new ArrayList<Map<Integer, Integer>>();
			tempFromToPegList.add(currFromToMap);
			tempFromToPegList.add(nextFromToMap);

			tempFromToPegList.forEach(currMovement -> {
				if (!position.containsKey(currMovement)) {
					position.put(currMovement, 0);
				}
				position.put(currMovement, position.get(currMovement) + 1);

			});
		}
		
		Map<Integer, Integer> currMovement = movementList.get(movementCount - 1);
		if (!position.containsKey(currMovement)) {
			position.put(currMovement, 0);
		}
		position.put(currMovement, position.get(currMovement) + 1);
		return mergeStatistics(position, a, b, c);
	}

	/**
	 * This method is used to merge statistics by checking key value paired in current state
	 * @param state
	 * @param a rod a value
	 * @param b rod b value
	 * @param c rod c value
	 * @return Map<Map<Integer, Integer>, Integer>
	 */
	public Map<Map<Integer, Integer>, Integer> mergeStatistics(Map<Map<Integer, Integer>, Integer> state, int rodA, int rodB,
			int rodC) {
		
		Map<Integer, Integer> abRodMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> bcRodMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> acRodMap = new HashMap<Integer, Integer>();
		abRodMap.put(rodA, rodB);
		bcRodMap.put(rodB, rodC);
		acRodMap.put(rodA, rodC);
		if (state.containsKey(abRodMap) && state.containsKey(bcRodMap) && state.get(abRodMap) == state.get(bcRodMap)) {
			if (!state.containsKey(acRodMap)) {
				state.put(acRodMap, 0);
			}
			state.put(acRodMap, state.get(acRodMap) + state.get(abRodMap));
			state.remove(abRodMap);
			state.remove(bcRodMap);
		}

		Map<Integer, Integer> cbRodMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> baRodMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> caRodMap = new HashMap<Integer, Integer>();
		cbRodMap.put(rodC, rodB);
		baRodMap.put(rodB, rodA);
		caRodMap.put(rodC, rodA);
		if (state.containsKey(cbRodMap) && state.containsKey(baRodMap) && state.get(cbRodMap) == state.get(baRodMap)) {
			if (!state.containsKey(caRodMap)) {
				state.put(caRodMap, 0);
			}
			state.put(caRodMap, state.get(caRodMap) + state.get(cbRodMap));
			state.remove(cbRodMap);
			state.remove(baRodMap);
		}

		return state;
	}

}
