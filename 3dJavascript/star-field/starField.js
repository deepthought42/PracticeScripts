var camera, scene, renderer;

var mouseX = 0, mouseY = 0;

var particles = [];

init();

function init() {
  //Camera params :
  // field of view, aspect ratio for render output, near and far clipping plane. 
  camera = new THREE.PerspectiveCamera(80, window.innerWidth/window.innerHeight, 1, 4000);
  
  //move the camera backwards so we can see stuff;
  //default position is 0,0,0
  camera.position.z = 1000;  
  
  // the scene contains all the 3D object data
  scene = new THREE.Scene();
  scene.add(camera);
  
  // and the CanvasRenderer figures out what the
  // stuff in the scene looks like and draws it!
  
  renderer = new THREE.CanvasRenderer();
  renderer.setSize(window.innerWidth, window.innerHeight );
  
  //the renderer's canvas domeElement is added to the body
  document.body.appendChild( renderer.domElement);
  
  makeParticles();
  
  //add the mouse move listener
  document.addEventListener( 'mousemove', onMouseMove, false );
  
  // render 30 times a second (should alos look at 
  // requestAnimationFrame)
  setInterval(update, 1000/30);
  
  
}

function update() {
	updateParticles();
	
	//and render the scene from the perspective of the camera
	renderer.render(scene, camera);
}

// creates a random field of Particle objects

function makeParticles() {
  var particle, material;
  
  // we're gonna move from z position -1000 (far away)
  // to 1000 (where the camera is) and add a random particle
  // at every position
  for (var zpos = -1000; zpos < 1000; zpos += 20 ) {
	// we make a particle material and pass through the
	// colour and custom particle render function vs defined.
	material = new THREE.ParticleCanvasMaterial( { color: 0xffffff, program : particleRender } );
	//make the particle
	particle = new THREE.Particle(material);
	
	//give it a random x and y position between -500 and 500
	particle.position.x = Math.random() * 1000 - 500;
	particle.position.y = Math.random() * 1000 - 500;
	
	// set its z position
	particle.position.z = zpos;
	
	// scale it up a bit
	particle.scale.x = particle.scale.y = 10;
	
	// add it to the scene
	scene.add(particle);
	
	// and to the array of particles.
	particles.push(particle);
  }
}

function particleRender( context ) {
  // we get passed a reference to the canvas context
  context.beginPath();
  // and we just have to draw our shape at 0,0 - in this
  // case an arc from 0 to 2Pi radians or 360 degress - a full circle!
  context.arc( 0, 0, 1, 0, Math.PI * 2, true);
  context.fill();
}

function updateParticles() {
  // iterate through every particle
  for(var i = 0; i < particles.length; i++){
	particle - particles[i];
	
	// and move it forward dependent on the mouseY position.
	particle.position.z += mouseY * 0.1;
	
	// if the particle is too close move it to the back
	if(particle.position.z > 1000) particle.position.z -= 2000;
	
  }
  
function onMouseMove(event) {
  // store the mouseX and mouseY position
  mouseX = event.clientX;
  mouseY = event.clientY;
}
}