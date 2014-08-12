		var Mes = [ 'FIRST-HALF', 'FIRST-STOPPAGE', 'SECOND-HALF',
				'SECOND-STOPPAGE' ];
		var index = 0;
		var $ = function(id) {
			return "string" == typeof id ? document.getElementById(id) : id;
		};

		var Class = {
			create : function() {
				return function() {
					this.initialize.apply(this, arguments);
				}
			}
		}

		var Extend = function(destination, source) {
			for ( var property in source) {
				destination[property] = source[property];
			}
			return destination;
		}

		var Calendar = Class.create();
		Calendar.prototype = {
			initialize : function(container, options) {
				this.Container = $(container);
				this.SetOptions(options);
				this.onFinish = this.options.onFinish;
				this.Draw();
			},
			SetOptions : function(options) {
				this.options = {
					SelectDay : null,
					onSelectDay : function() {
					},
					onToday : function() {
					},
					onFinish : function() {
					}
				};
				Extend(this.options, options || {});
			},
			PreMonth : function() {
				if (index == 0) {
					index = 0;
				} else {
					index = index - 1;
				}
				this.Draw();
			},

			NextMonth : function() {
				if (index == 3) {
					index = 3;
				} else {
					index = index + 1;
				}
				this.Draw();
			},
			Draw : function() {
				var arr = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
						16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
						30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
						44, 45 ];
				this.Days = [];
				var frag = document.createDocumentFragment();
				while (arr.length) {
					var row = document.createElement("tr");
					for ( var i = 1; i <= 10; i++) {
						var cell = document.createElement("td");
						cell.innerHTML = "&nbsp;";
						if (arr.length) {
							var d = arr.shift();
							if (d) {
								cell.innerHTML = d;
								this.Days[d] = cell;
							}
						}
						row.appendChild(cell);
					}
					frag.appendChild(row);
				}
				while (this.Container.hasChildNodes()) {
					this.Container.removeChild(this.Container.firstChild);
				}
				this.Container.appendChild(frag);
				this.onFinish();
			}
		}
