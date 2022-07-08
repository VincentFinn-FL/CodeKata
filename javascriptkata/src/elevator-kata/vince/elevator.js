{
    init: function (elevators, floors) {
        // elevator
        // its on 0
        // pressed 2 button
        // if load factor 0, grab the nearest passenger
        // always go to the farthest, and stop along the way to drop off
        // when going to floor, stop at floors if matching direction is on that floor
        //

        var floorUpQueue = [];
        var floorDownQueue = [];

        function getFloorQueue() {
            return floorDownQueue.concat(floorDownQueue);
        }

        function goToNearestPassenger(elevator) {
            var closestFloor = 0;
            var currentFloor = elevator.currentFloor();
            var targetFloor = 0;
            var minimumDistance = 100;
            getFloorQueue().forEach((floorNum) => {
                var distance = Math.abs(currentFloor - floorNum);
                if (distance < minimumDistance) {
                    targetFloor = floorNum;
                    minimumDistance = distance
                }
            })
            elevator.goToFloor(targetFloor)
        }

        floors.forEach((floor) => {
            floor.on("up_button_pressed", function () {
                floorUpQueue.push(floor.floorNum())
            });
            floor.on("down_button_pressed", function () {
                floorDownQueue.push(floor.floorNum())
            });
        })

        elevators.forEach((elevator) => {
            elevator.on("idle", function () {
                goToNearestPassenger(elevator);
            });
            elevator.on("stopped_at_floor", function (floorNum) {
                for (var i = 0; i < floorUpQueue.length; i++) {

                    if (floorUpQueue[i] === floorNum) {

                        floorUpQueue.splice(i, 1);
                    }

                }
                for (var i = 0; i < floorDownQueue.length; i++) {

                    if (floorDownQueue[i] === floorNum) {

                        floorDownQueue.splice(i, 1);
                    }

                }
            });
        })
    }
,
    update: function (dt, elevators, floors) {
        // We normally don't need to do anything here
    }
}